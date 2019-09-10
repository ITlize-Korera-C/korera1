package com.groupc.pt.model;

import java.util.*;
import javax.persistence.*;

@Entity(name = "ProjectResource")
@Table(name = "ProjectResource")
public class ProjectResource{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long ProjectResourceId;
   
   public ProjectResource() {};
   
   public Long getId() {
	      return ProjectResourceId;
	   }

	   public void setId(Long id) {
	      this.ProjectResourceId = id;
	   }
   
	@ManyToOne
	@JoinColumn(name = "projId")
	private Projects project;
	
	@ManyToOne
	@JoinColumn(name = "resId")
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
