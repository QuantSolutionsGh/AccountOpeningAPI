package com.databankgroup.gh.accopeningapi.model;

public class FileDetails {
	
	public String fileName;
	public String applicationRef;
	public long fileIndex;
	public String docType;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getApplicationRef() {
		return applicationRef;
	}
	public void setApplicationRef(String applicationRef) {
		this.applicationRef = applicationRef;
	}
	public long getFileIndex() {
		return fileIndex;
	}
	public void setFileIndex(long fileIndex) {
		this.fileIndex = fileIndex;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
}
