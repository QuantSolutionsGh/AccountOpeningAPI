package com.databankgroup.gh.accopeningapi.dao;


import com.databankgroup.gh.accopeningapi.model.UserDocument;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
public class UserDocumentDao implements IUserDocumentDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	
	public void store(UserDocument userDocument) {
		entityManager.persist(userDocument);
		
	}

	@Override
	
	public void delete(Long id) {
		entityManager.remove(this.findById(id));
		
	}

	@Override
	public UserDocument findById(Long id) {
		return entityManager.find(UserDocument.class, id);
	}

	

	@Override
	public ArrayList<UserDocument> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserDocument> fetchDocs(Long id, String docType) {
		Query q = this.entityManager
				.createQuery("select a from UserDocument a where" +
						" a.appBean.id=:id and a.type=:type");
		q.setParameter("id", id);
		q.setParameter("type",docType);
		ArrayList<UserDocument> al = (ArrayList<UserDocument>) q.getResultList();

		return al;
	}


	@Override
	public Set<UserDocument> findAll(Long id) {
		Query q= this.entityManager.createQuery("select a from UserDocument a where a.appBean.id=:id");
		q.setParameter("id",id);
		return new HashSet<UserDocument>(q.getResultList());

	}

	@Override
	public UserDocument findByAppRef(String appRef) {
		return null;
	}

}
