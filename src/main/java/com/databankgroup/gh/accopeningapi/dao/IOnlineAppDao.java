package com.databankgroup.gh.accopeningapi.dao;


import com.databankgroup.gh.accopeningapi.model.AppBean;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public interface IOnlineAppDao {
	
	public void store(AppBean appBean);
	
	public void delete(Long id);
	
	public AppBean findById(Long id);
	
	public AppBean find(String email, String appRef);
	
	public ArrayList<AppBean>findAll();
	
	public AppBean findByAppRef(String appRef);

	public EntityManager getEntityManager();  //last minute hack to expose this in maincontroller inorder to run other scripts than can be found here

}
