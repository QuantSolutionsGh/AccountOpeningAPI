package com.databankgroup.gh.accopeningapi.dao;

import com.databankgroup.gh.accopeningapi.model.UserDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface UserDocumentRepository extends JpaRepository<UserDocument,Long> {

    @Query("select t from UserDocument t where t.appBean.id = :id")
    Set<UserDocument> findDocsByAppBean(@Param("id") Long id);
}
