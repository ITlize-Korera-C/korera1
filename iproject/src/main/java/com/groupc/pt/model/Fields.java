package com.groupc.pt.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Fields")
public class Fields implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "fieldId")
	private long fieldId;
	
	@Column(name = "fieldType")
	private String typeOfField;

	@Column(name = "fieldName")
	private String fieldName;

	@Column(name = "isVisible") //mark for frontEnd feature
	private String isVisible;
	
	@OneToOne
	@JoinColumn(name = "fieldId")
	private Formulas formulas;
	
	public long getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getTypeOfField() {
		return typeOfField;
	}

	public void setTypeOfField(String typeOfField) {
		this.typeOfField = typeOfField;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}
}
