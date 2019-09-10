package com.groupc.pt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "PRFieldValues")
@Table(name = "PRFieldValuesInfo")
public class PRFieldValues{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private long fieldIde;
   private long ProjectResourceId;
   private long FieldValue;
   
	@ManyToOne
	@JoinColumn(name = "Rowid")
	private ProjectResource ProjectResource;
	
	@ManyToOne
	@JoinColumn(name = "fieldId")
	private Fields fields;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public long getFieldId() {
      return fieldIde;
   }
   public void setFieldId(long fieldIde) {
	   this.fieldIde = fieldIde;
   }
   

   public long getProjectResourceId() {
      return ProjectResourceId;
   }

   public void setProjectResourceId(long ProjectResourceId) {
      this.ProjectResourceId = ProjectResourceId;
   }
   
   public long getFieldValue() {
	      return FieldValue;
	   }

	   public void setFieldValue(long FieldValue) {
	      this.FieldValue = FieldValue;
	   }


}
