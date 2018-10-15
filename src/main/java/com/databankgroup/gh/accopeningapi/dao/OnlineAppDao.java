package com.databankgroup.gh.accopeningapi.dao;

import com.databankgroup.gh.accopeningapi.model.AppBean;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Repository

@Transactional
public class OnlineAppDao implements IOnlineAppDao {

	@PersistenceContext
	private EntityManager entityManager;

	

	@Override

	
	public void store(AppBean appBean) {
		if (appBean.getApplicationRef() == null) {
			appBean.setApplicationRef(RandomStringUtils.randomAlphanumeric(10));

			entityManager.persist(appBean);
		} else
			entityManager.merge(appBean);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public AppBean findById(Long id) {
		Query q = this.entityManager.createQuery("select a from AppBean a where a.id=:id");
		q.setParameter("id", id);
		ArrayList<AppBean> al = (ArrayList<AppBean>) q.getResultList();

		if (al.isEmpty()) {
			return null;

		} else
			Hibernate.initialize(al.get(0).getUserDocuments());
			return al.get(0);
	}

	@Override

	public AppBean find(String email, String appRef) {

		// Query q = this.entityManager.createQuery("select a from AppBean a
		// where a.email=:email and a.id=:id");
		// q.setParameter("email", email);
		// q.setParameter("id",Long.valueOf(appRef));

        //20 Jan,2018 am not sure of the places where this is called apart from retrieveApplication
		Query q = this.entityManager
				.createQuery("select a from AppBean a where upper(a.email)=:email and a.accountNumber is null and a.applicationRef=:id");
		q.setParameter("email", email.toUpperCase());
		q.setParameter("id", appRef);
		ArrayList<AppBean> al = (ArrayList<AppBean>) q.getResultList();

		if (al.isEmpty()) {
			return new AppBean();

		} else
			Hibernate.initialize(al.get(0).getUserDocuments());

			return al.get(0);

	}

	@Override
	public ArrayList<AppBean> findAll() {
		Query q = this.entityManager.createQuery("select a from AppBean a order by a.id desc");
		ArrayList<AppBean> al = (ArrayList<AppBean>) q.getResultList();
		return al;
	}

	@Override
	
	public AppBean findByAppRef(String appRef) {
		Query q = this.entityManager
				.createQuery("select a from AppBean a where a.applicationRef=:appRef ");
		q.setParameter("appRef", appRef);
		ArrayList<AppBean> al = (ArrayList<AppBean>) q.getResultList();
		if (al.isEmpty()) {
			return null;

		} else
			Hibernate.initialize(al.get(0).getUserDocuments());  //note this should always be within a @transactiona method

			return al.get(0);
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
