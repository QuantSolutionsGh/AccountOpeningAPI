package com.databankgroup.gh.accopeningapi.controller;


import com.databankgroup.gh.accopeningapi.dao.*;
import com.databankgroup.gh.accopeningapi.integeration.IServiceIntegeration;
import com.databankgroup.gh.accopeningapi.model.AppBean;
import com.databankgroup.gh.accopeningapi.model.AppBeanVitals;
import com.databankgroup.gh.accopeningapi.model.UserDocument;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestAccnoGenAPI {

    //@Autowired
    //private Apphandler apphandler;

    @Autowired
    private AppBeanRepository appBeanRepository;

    @Autowired
    private AppBeanVitalsRepository appBeanVitalsRepository;

    @Autowired
    private UserDocumentRepository userDocumentRepository;



    @Autowired
    @Qualifier("serviceIntegeration")
    private IServiceIntegeration serviceIntegeration;

    @Value("${app.milesAccNoGenEndPoint}")
    private String milesAccNoGenEndPoint;


    private void saveDocToDB(String docType, MultipartFile file, AppBean appBean) throws IOException {

        UserDocument userDoc = new UserDocument();
        userDoc.setAppBean(appBean);
        userDoc.setContent(file.getBytes());
        userDoc.setName(file.getOriginalFilename());
        userDoc.setType(docType);
        userDoc.setDescription(RandomStringUtils.randomAlphanumeric(10)+"."+
                FilenameUtils.getExtension(file.getOriginalFilename()) );
        userDocumentRepository.save(userDoc);

    }








    @RequestMapping(value = "/rest/api/v1/custdetails", method = RequestMethod.POST)

    public ResponseEntity<String> update2(
            @ModelAttribute @Valid AppBean appBean
    ) throws Exception {


         appBean.setApplicationRef(RandomStringUtils.randomAlphanumeric(10));
         appBean.setUserName(getPrincipal());

         appBeanRepository.save(appBean);

         AppBeanVitals appBeanVitals = new AppBeanVitals();
         appBeanVitals.setAppBean(appBean);
         appBeanVitals.setAppInceptionDate(new Date());

         appBeanVitalsRepository.save(appBeanVitals);

        saveDocToDB("passport",appBean.getPassportImage(),appBean);
        saveDocToDB("photoId",appBean.getPhotoIDImage(),appBean);
        saveDocToDB("signature",appBean.getSignatureImage(),appBean);
        saveDocToDB("proofOfAddress",appBean.getProofOfAddressImage(),appBean);



        ArrayList<String> userDocs = new ArrayList<String>();


        Set<UserDocument>appUserDocuments =userDocumentRepository.findDocsByAppBean(appBean.getId());

        for (UserDocument u : appUserDocuments) {
            userDocs.add(u.getDescription());
        }

        if (!userDocs.isEmpty()){
            appBean.setDocRef(serviceIntegeration.storeDoc(userDocs));}


        //now that we have the docRef as well let's persist into DB
        appBeanRepository.save(appBean);


        serviceIntegeration.saveUserDocsToDisk(appUserDocuments);
        //for GHL fetch account #
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);



        ResponseEntity<String> response= restTemplate.exchange(milesAccNoGenEndPoint + "/"+appBean.getApplicationRef(),
                HttpMethod.GET,entity,String.class);




        return  response;

    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }











}