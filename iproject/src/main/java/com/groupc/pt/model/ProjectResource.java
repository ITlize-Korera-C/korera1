package com.groupc.pt.model;

import java.util.*;
import javax.persistence.*;

@Entity(name = "ProjectResource")
@Table(name = "ProjectResource")
public class ProjectResource{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Rowid;
   
   public ProjectResource() {};
   
   public Long getId() {
	      return Rowid;
	   }

	   public void setId(Long id) {
	      this.Rowid = id;
	   }
   
	@ManyToOne
	@JoinColumn(name = "resId")
	private Projects project;
	
	@ManyToOne
	@JoinColumn(name = "projId")
	private Resource resource;
	

	
	public void setProject(Projects projects) {
		this.project = projects;
	}
	
	public Projects getProject() {
		return project;
	}
	
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	public Resource getResource() {
		return resource;
	}
	
}
