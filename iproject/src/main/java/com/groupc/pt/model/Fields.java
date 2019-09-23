package com.groupc.pt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Fields")
public class Fields implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fieldId;
	
	@Column(name = "fieldType")
	private String typeOfField;

	@Column(name = "fieldName")
	private String fieldName;

	@Column(name = "isVisible") //mark for frontEnd feature
	private String isVisible;
	
	@Column(name = "formula")
	private String formula;
	
	@OneToOne
	@JoinColumn(name = "fieldId")
	private Formulas formulas;
	
	@OneToMany(mappedBy = "fields")
	private Set<PRFieldValues> PRFieldValues;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "projId",nullable = false)
	private Projects projects;
//set ID	
	public Long getFieldId() {
		return fieldId;
	}
	
	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

//	
	public void setProject(Projects project){
		this.projects = project;
	}

//set type	
	public String getTypeOfField() {
		return typeOfField;
	}

	public void setTypeOfField(String typeOfField) {
		this.typeOfField = typeOfField;
	}
//set name
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
//set visibility
	public String getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}
//	
//	public Long getProjId() {
//		return projects.getId();
//	}
	
	public String getFormula() {
		return this.formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
}
