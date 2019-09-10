package com.groupc.pt.model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Projects")
public class Projects{	

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long projId;
	   private String name;
	  


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

	  
}
