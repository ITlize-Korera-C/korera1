package com.groupc.pt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Formula")
@Table(name = "FormulaList")
public class Formulas{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long formulaId;
   private String Formula;
   
	@OneToOne
	@JoinColumn(name = "fieldId")
	private Fields fields;
	

   public Long getId() {
      return formulaId;
   }

   public void setId(Long formulaId) {
      this.formulaId = formulaId;
   }
   
   public void setFormula(String Formula) {
	   this.Formula = Formula;
   }
   
   public String getFormula() {
	   return Formula;
   }


}
