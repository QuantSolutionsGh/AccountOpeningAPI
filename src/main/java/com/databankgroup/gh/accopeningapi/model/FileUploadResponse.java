package com.databankgroup.gh.accopeningapi.model;

import java.util.ArrayList;

public class FileUploadResponse {
	
	private String uploadStatus;  
	
	private ArrayList<FileDetails> files;

	public String getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public ArrayList<FileDetails> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<FileDetails> files) {
		this.files = files;
	}

	
	
	
	

}
