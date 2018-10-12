package com.databankgroup.gh.accopeningapi.integeration;


import com.databankgroup.gh.accopeningapi.model.UserDocument;

import java.util.ArrayList;
import java.util.Set;

public interface IServiceIntegeration {
	
	//persists documents in database to disk (ie. docman storage)
	public void saveUserDocsToDisk(Set<UserDocument> documents);

	public boolean checkUserExists(String userName) throws Exception; // from Nelson's DOT's
														// table

	public String storeDoc(ArrayList<String> documents) throws Exception;  //documents are already in docman just save document files and generate docref #

}
