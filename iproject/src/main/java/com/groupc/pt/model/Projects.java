package com.groupc.pt.model;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.groupc.pt.model.Resource;

@Entity(name = "Projects")
public class Projects{	

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long projId;
	   private String name;
	   
	   @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
		@JoinTable(name = "Project_Resource", joinColumns = {
				@JoinColumn(name = "projId", referencedColumnName = "projId") }, inverseJoinColumns = {
						@JoinColumn(name = "resId", referencedColumnName = "resId") })
		private Set<Resource> resources = new HashSet<Resource>(0);
	  
	   
	   @OneToMany(mappedBy = "projects", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	   //@JsonIgnore
	   private Set<Fields> fields;
	   
	   public Long getId() {
	      return projId;
	   }

	   public void setId(Long id) {
	      this.projId = id;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
	   
	   public Set<Fields> getFields() {
		   return this.fields;
	   }
	
	   public void setFields(Set<Fields> fields) {
		   this.fields = fields;
	   }
	   

	  
}
