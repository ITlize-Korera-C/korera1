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

import com.groupc.pt.model.PRFieldValues;
import com.groupc.pt.service.PRFService;

@CrossOrigin
@RestController
public class PRFController {
		@Autowired
		private PRFService PRFService;
	   /*---Add new Resouce---*/
	   @PostMapping("/PRFieldValues")
	   public ResponseEntity<?> save(@RequestBody PRFieldValues KResouce) {
	      long id = PRFService.save(KResouce);
	      return ResponseEntity.ok().body("New PRFieldValues has been saved with ID:" + id);
	   }
	   

	   /*---Get a Resouce by id---*/
	   @GetMapping("/PRFieldValues/{id}")
	   public ResponseEntity<PRFieldValues> get(@PathVariable("id") long id) {
		   PRFieldValues KResouce = PRFService.getU(id);
	      return ResponseEntity.ok().body(KResouce);
	   }

	   /*---get all Resouces---*/
	   @GetMapping("/PRFieldValues")
	   public ResponseEntity<List<PRFieldValues>> list() {
	      List<PRFieldValues> KResouces = PRFService.userlist();
	      return ResponseEntity.ok().body(KResouces);
	   }

	   /*---Update a Resouce by id---*/
	   @PutMapping("/PRFieldValues/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody PRFieldValues KResouce) {
		   PRFService.update(id, KResouce);
	      return ResponseEntity.ok().body("PRFieldValues"+id+" has been updated successfully.");
	   }

	   /*---Delete a Resouce by id---*/
	   @DeleteMapping("/PRFieldValues/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   PRFService.deleteU(id);
	      return ResponseEntity.ok().body("PRFieldValues"+id+" has been deleted successfully.");
	   }
}
