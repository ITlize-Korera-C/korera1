package com.groupc.pt.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Repository;

import com.groupc.pt.model.Resource;

@Entity
public class Resource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resId;
	private long ResourceCode;
	private String ResourceName;
	
	public Long getId() {
		return resId;
	}

	public void setId(Long resid) {
		this.resId = resid;
	}

	public long getResourceCode() {
		return ResourceCode;
	}
	
	public void setResourceCode(long ResourceCode) {
		this.ResourceCode = ResourceCode;
	}

	public void setResourceName(String ResourceName) {
		this.ResourceName = ResourceName;
	}

	public String getResourceName() {
		return ResourceName;
	}

}
