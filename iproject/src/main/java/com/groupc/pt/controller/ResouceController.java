package com.groupc.pt.controller;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groupc.pt.model.Resource;
import com.groupc.pt.service.ResourceService;
@RestController
public class ResouceController {
		@Autowired
		private ResourceService ResouceService;
	   /*---Add new Resouce---*/
	   @PostMapping("/Resouce")
	   public ResponseEntity<?> save(@RequestBody Resource KResouce) {
	      long id = ResouceService.save(KResouce);
	      return ResponseEntity.ok().body("New Resouce has been saved with ID:" + id);
	   }
	   

	   /*---Get a Resouce by id---*/
	   @GetMapping("/Resouce/{id}")
	   public ResponseEntity<Resource> get(@PathVariable("id") long id) {
		   Resource KResouce = ResouceService.getU(id);
	      return ResponseEntity.ok().body(KResouce);
	   }

	   /*---get all Resouces---*/
	   @GetMapping("/Resouce")
	   public ResponseEntity<List<Resource>> list() {
	      List<Resource> KResouces = ResouceService.userlist();
	      return ResponseEntity.ok().body(KResouces);
	   }

	   /*---Update a Resouce by id---*/
	   @PutMapping("/Resouce/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Resource KResouce) {
		   ResouceService.update(id, KResouce);
	      return ResponseEntity.ok().body("Resouce"+id+" has been updated successfully.");
	   }

	   /*---Delete a Resouce by id---*/
	   @DeleteMapping("/Resouce/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   ResouceService.deleteU(id);
	      return ResponseEntity.ok().body("Resouce"+id+" has been deleted successfully.");
	   }
	   
}
	   

