package com.databankgroup.gh.accopeningapi.integeration;


import com.databankgroup.gh.accopeningapi.model.UserDocument;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import org.apache.commons.io.IOUtils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;

@Component
public class ServiceIntegeration implements IServiceIntegeration {

	@Value("${dots.jdbcUrl}")
	public String jdbcUrlDotsDatabase;

	@Value("${docman.jdbcUrl}")
	public String jdbcUrlDocManDatabase;

	@Value("${database.classname}")
	public String databaseClassName;

	@Value("${dots.database.userName}")
	public String dotsUserName;

	@Value("${dots.database.userPassword}")
	public String dotsUserPassword;

	@Value("${docman.database.userName}")
	public String docmanUserName;

	@Value("${docman.database.userPassword}")
	public String docmanUserPassowrd;

	@Value("${docman.storagePath}")
	public String storagePath;

	@Value("${app.docStoreCredentials}")
	public String docStoreCredentials;

	@Override
	public boolean checkUserExists(String userName) throws Exception {

		// connect to the DOTS database and check if user exist

		Class.forName(databaseClassName);
		Connection con = DriverManager.getConnection(jdbcUrlDotsDatabase, dotsUserName, dotsUserPassword);

		PreparedStatement myStatement = null;

		String sqlStatement = "select 1 from users where upper(username)=upper(?)";

		myStatement = con.prepareStatement(sqlStatement);

		myStatement.setString(1, userName);

		// ResultSet rs = myStatement.executeQuery();

		ResultSet rs = myStatement.executeQuery();

		if (!rs.next()) {
			// ResultSet is empty so username does not exist
			return false;
		} else
			return true; // username already exists

	}

	@Override
	public String storeDoc(ArrayList<String> documents) throws Exception {

		Class.forName(databaseClassName);
		Connection con = DriverManager.getConnection(jdbcUrlDocManDatabase, docmanUserName, docmanUserPassowrd);
		con.setAutoCommit(false);
		PreparedStatement myStatement = null;

		String sqlStatement = "select max(doc_ref)+1 docRef from sequencer";
		myStatement = con.prepareStatement(sqlStatement);
		ResultSet rs = myStatement.executeQuery();

		rs.next(); // move to the first row in the result set
		String docRef = rs.getString(1);

		// mark the docref number as in use

		PreparedStatement updateStatement = null;
		String updateSql = "update sequencer set doc_ref=?";
		updateStatement = con.prepareStatement(updateSql);
		updateStatement.setString(1, docRef);
		updateStatement.executeUpdate();

		// so now that I have the docRef, I am going to insert user documents
		// into document management system

		PreparedStatement insertStatement = null;

		String insertSql = "insert into tbl_main(doc_ref,file_name) values (?,?)";
		insertStatement = con.prepareStatement(insertSql);
		int i = 1;

		for (String doc : documents) {
			insertStatement.setString(1, docRef);
			insertStatement.setString(2, doc);
			insertStatement.executeUpdate();

		}
		con.commit();

		return docRef;
	}

	
	
	/*
	 * One of my main headaches is persisting these from 250.1 to 200.250 I
	 * cannot save directly because it fails because of authentication issues.
	 * So I have had to use the jcifs library which uses smb to connect to
	 * 200.250. The challenge i was facing when during a direct save upon file
	 * upload was that there were times that saving was painfully slow
	 * i.e(writing 4 bytes in 10 minutes). This was causing file uploads to time
	 * out. That is why i have had to use the database to persist initially file
	 * uploads and then over here (well i think we have time!!) persist the
	 * files into the storage async
	 * 
	 * String command=
	 * "net use K: \\\\10.234.34..\\test\\ /USER:username password"; Process
	 * output = Runtime.getRuntime().exec(command);
	 * https://stackoverflow.com/questions/24912430/jcifs-connection-breaks
	 * -->important
	 * 
	 * https://stackoverflow.com/questions/208839/how-can-i-mount-a-windows-
	 * drive-in-java
	 * 
	 * https://stackoverflow.com/questions/208839/how-can-i-mount-a-windows-
	 * drive-in-java
	 */
	@Async
	@Override
	public void saveUserDocsToDisk(Set<UserDocument> documents) {
		final Logger logger = Logger.getLogger(ServiceIntegeration.class);

		try {

			for (UserDocument u : documents) {
				logger.info(
						"-------------------------PERISTING FILE TO STORAGE :" + u.getName() + "--------------------");

				NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(this.docStoreCredentials);
				String path = "smb:" + storagePath + "/" + u.getDescription();
				SmbFile file = new SmbFile(path, auth);
				OutputStream out = file.getOutputStream();
				ByteArrayInputStream in = new ByteArrayInputStream(u.getContent());
				IOUtils.copy(in, out);
				in.close();
				out.close();
				logger.info("-------------------------PERSISTING FILE TO STORE COMPLETED :" + u.getName()
						+ "--------------------");

			}
		} catch (Exception e) {
			logger.error(e.getMessage());

		}

	}

}
