package com.databankgroup.gh.accopeningapi.controller;


import com.databankgroup.gh.accopeningapi.dao.IOnlineAppDao;
import com.databankgroup.gh.accopeningapi.dao.IUserDocumentDao;
import com.databankgroup.gh.accopeningapi.integeration.IServiceIntegeration;
import com.databankgroup.gh.accopeningapi.model.AppBean;
import com.databankgroup.gh.accopeningapi.model.UserDocument;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
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

    private IOnlineAppDao onlineAppDao;

    @Autowired
    public IUserDocumentDao userDocumentDao;

    @Autowired
    @Qualifier("serviceIntegeration")
    private IServiceIntegeration serviceIntegeration;

    @Value("${app.milesAccNoGenEndPoint}")
    private String milesAccNoGenEndPoint;


    private void saveDocToDB(String docType, MultipartFile file, long appId) throws IOException {

        UserDocument userDoc = new UserDocument();
        AppBean appBean=onlineAppDao.findById(appId);
        userDoc.setAppBean(appBean);
        userDoc.setContent(file.getBytes());
        userDoc.setName(file.getOriginalFilename());
        userDoc.setType(docType);
        userDoc.setDescription(RandomStringUtils.randomAlphanumeric(10)+"."+
                FilenameUtils.getExtension(file.getOriginalFilename()) );
        userDocumentDao.store(userDoc);

    }



    @RequestMapping(value = "/rest/api/v1/custdetails", method = RequestMethod.POST)

    public ResponseEntity<String> update(
            @RequestPart("accdetails") @Valid AppBean appBean,
            @RequestPart("passport") MultipartFile passportFile,
            @RequestPart("photoId") MultipartFile photoIdFile,
            @RequestPart("signature") MultipartFile signatureFile,
            @RequestPart("proofOfAddress") MultipartFile proofOfAddressFile,Errors errors) throws Exception {


        // appBean.setApplicationRef(RandomStringUtils.randomAlphanumeric(10)); not needed cos it's already defined in onlineAppDao.store(appBean)
        //appBean.setAccountType("Individual");

        appBean.getAppBeanVitals().setAppInceptionDate(new Date());
        onlineAppDao.store(appBean);



        saveDocToDB("passport",passportFile,appBean.getId());
        saveDocToDB("photoId",photoIdFile,appBean.getId());
        saveDocToDB("signature",signatureFile,appBean.getId());
        saveDocToDB("proofOfAddress",proofOfAddressFile,appBean.getId());

        AppBean dummyAppBean = onlineAppDao.findById(appBean.getId());

        Hibernate.initialize(dummyAppBean.getUserDocuments());

        ArrayList<String> userDocs = new ArrayList<String>();
        Set<UserDocument> appUserDocuments = dummyAppBean.getUserDocuments();

        for (UserDocument u : appUserDocuments) {
            userDocs.add(u.getDescription());
        }

        if (!userDocs.isEmpty()){
            appBean.setDocRef(serviceIntegeration.storeDoc(userDocs));}


        //now that we have the docRef as well let's persist into DB
        onlineAppDao.store(appBean);

        Set<UserDocument> documents = dummyAppBean.getUserDocuments();
        serviceIntegeration.saveUserDocsToDisk(documents);
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





    @RequestMapping(value = "/rest/api/v1.1/custdetails", method = RequestMethod.POST)

    public ResponseEntity<String> update2(
            @ModelAttribute @Valid AppBean appBean
    ) throws Exception {


        // appBean.setApplicationRef(RandomStringUtils.randomAlphanumeric(10)); not needed cos it's already defined in onlineAppDao.store(appBean)
        //appBean.setAccountType("Individual");

        appBean.getAppBeanVitals().setAppInceptionDate(new Date());

        onlineAppDao.store(appBean);

        saveDocToDB("passport",appBean.getPassportImage(),appBean.getId());
        saveDocToDB("photoId",appBean.getPhotoIDImage(),appBean.getId());
        saveDocToDB("signature",appBean.getSignatureImage(),appBean.getId());
        saveDocToDB("proofOfAddress",appBean.getProofOfAddressImage(),appBean.getId());

       // AppBean dummyAppBean = onlineAppDao.findById(appBean.getId());



        ArrayList<String> userDocs = new ArrayList<String>();
       // Set<UserDocument> appUserDocuments = dummyAppBean.getUserDocuments();

        Set<UserDocument>appUserDocuments =userDocumentDao.findAll(appBean.getId());

        for (UserDocument u : appUserDocuments) {
            userDocs.add(u.getDescription());
        }

        if (!userDocs.isEmpty()){
            appBean.setDocRef(serviceIntegeration.storeDoc(userDocs));}


        //now that we have the docRef as well let's persist into DB
        onlineAppDao.store(appBean);

        //Set<UserDocument> documents = dummyAppBean.getUserDocuments();
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











}