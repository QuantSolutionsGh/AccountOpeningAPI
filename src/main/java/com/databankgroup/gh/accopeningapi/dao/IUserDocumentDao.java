package com.databankgroup.gh.accopeningapi.dao;


import com.databankgroup.gh.accopeningapi.model.UserDocument;

import java.util.ArrayList;

public interface IUserDocumentDao {
	
public void store(UserDocument userDocument);
	
	public void delete(Long id);
	
	public UserDocument findById(Long id);
	
	
	
	public ArrayList<UserDocument>findAll();

	public ArrayList<UserDocument>fetchDocs(Long id, String docType);

	
	public UserDocument findByAppRef(String appRef);


}
