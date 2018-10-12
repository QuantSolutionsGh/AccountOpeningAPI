package com.databankgroup.gh.accopeningapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserDocument implements  Serializable {
	
	private static final long serialVersionUID = -4221045095101467108L;
	
//	private static final long serialVersionUID = -4221045095101467108L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id; 
	
	@Version
	private Long version;
     
    @Column(name="name", length=100, nullable=false)
    private String name;
     
    @Column(name="description", length=255)
    private String description;
     
    @Column(name="type", length=100)
    private String type;
     
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name="content", nullable=false)
    private byte[] content;
 
    @ManyToOne(optional = false)
    @JoinColumn(name = "appbean")
    private AppBean appBean;

	

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public AppBean getAppBean() {
		return appBean;
	}

	public void setAppBean(AppBean appBean) {
		this.appBean = appBean;
	}
    
    

}
