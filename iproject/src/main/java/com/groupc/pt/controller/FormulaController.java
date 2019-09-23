package com.groupc.pt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groupc.pt.model.Formulas;
import com.groupc.pt.service.FormulaService;


@CrossOrigin
@RestController
public class FormulaController {
		@Autowired
		private FormulaService FormulaService;
	   /*---Add new Formula---*/
	   @PostMapping("/Formula")
	   public ResponseEntity<?> save(@RequestBody Formulas KFormula) {
	      long id = FormulaService.save(KFormula);
	      return ResponseEntity.ok().body("New Formula has been saved with ID:" + id);
	   }
	   

	   /*---Get a Formula by id---*/
	   @GetMapping("/Formula/{id}")
	   public ResponseEntity<Formulas> get(@PathVariable("id") long id) {
	      Formulas KFormula = FormulaService.getU(id);
	      return ResponseEntity.ok().body(KFormula);
	   }

	   /*---get all Formulas---*/
	   @GetMapping("/Formula")
	   public ResponseEntity<List<Formulas>> list() {
	      List<Formulas> KFormulas = FormulaService.Flist();
	      return ResponseEntity.ok().body(KFormulas);
	   }

	   /*---Update a Formula by id---*/
	   @PutMapping("/Formula/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Formulas KFormula) {
		   FormulaService.update(id, KFormula);
	      return ResponseEntity.ok().body("Formula"+id+" has been updated successfully.");
	   }

	   /*---Delete a Formula by id---*/
	   @DeleteMapping("/Formula/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   FormulaService.deleteU(id);
	      return ResponseEntity.ok().body("Formula"+id+" has been deleted successfully.");
	   }
	   
}
