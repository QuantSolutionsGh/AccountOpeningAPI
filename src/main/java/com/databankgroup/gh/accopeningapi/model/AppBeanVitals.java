package com.databankgroup.gh.accopeningapi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class AppBeanVitals implements Serializable{

    private static final long serialVersionUID = -4251045095101467108L;

//	private static final long serialVersionUID = -4221045095101467108L;

    @Id

    private long id;

    @Version
    private Long version;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date appInceptionDate ;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date appSubmitDate;  //finally form submission

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date emailVerificationDate;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date accountDetailsSentDate;

    @MapsId
    @OneToOne
    @JoinColumn(name="id")
    private AppBean appBean;


    @Column(length = 1000)
    private String comments;

    @Column
    private boolean appApproved=false;

    @Column
    private boolean appDeleted=false; //to handle scenarios where Keziah wants to remove a client from the confirmed list

    @Column
    private String relationshipType;  //relationship with next of kin


    @Column
    private String mandate;  //who to sign only applicable for joint account holders


    @Column
    private String introducer;


    public AppBean getAppBean() {
        return appBean;
    }

    public void setAppBean(AppBean appBean) {
        this.appBean = appBean;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getAppInceptionDate() {
        return appInceptionDate;
    }

    public void setAppInceptionDate(Date appInceptionDate) {
        this.appInceptionDate = appInceptionDate;
    }

    public Date getAppSubmitDate() {
        return appSubmitDate;
    }

    public void setAppSubmitDate(Date appSubmitDate) {
        this.appSubmitDate = appSubmitDate;
    }

    public Date getEmailVerificationDate() {
        return emailVerificationDate;
    }

    public void setEmailVerificationDate(Date emailVerificationDate) {
        this.emailVerificationDate = emailVerificationDate;
    }

    public Date getAccountDetailsSentDate() {
        return accountDetailsSentDate;
    }

    public void setAccountDetailsSentDate(Date accountDetailsSentDate) {
        this.accountDetailsSentDate = accountDetailsSentDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isAppApproved() {
        return appApproved;
    }

    public void setAppApproved(boolean appApproved) {
        this.appApproved = appApproved;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getIntroducer() {
        return introducer;
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer;
    }

    public boolean isAppDeleted() {
        return appDeleted;
    }

    public void setAppDeleted(boolean appDeleted) {
        this.appDeleted = appDeleted;
    }

    public String getMandate() {
        return mandate;
    }

    public void setMandate(String mandate) {
        this.mandate = mandate;
    }
}
