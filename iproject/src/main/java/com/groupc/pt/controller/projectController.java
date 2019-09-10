package com.groupc.pt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groupc.pt.model.Projects;
import com.groupc.pt.service.projectService;

@RestController
public class projectController {
		@Autowired
		private projectService projectService;
	   /*---Add new user---*/
	   @PostMapping("/project")
	   public ResponseEntity<?> save(@RequestBody Projects Kuser) {
	      long id = projectService.save(Kuser);
	      return ResponseEntity.ok().body("New project has been saved with ID:" + id);
	   }
	   

	   /*---Get a user by id---*/
	   @GetMapping("/project/{id}/r")
	   public ResponseEntity<Projects> get(@PathVariable("id") long id) {
	      Projects Kuser = projectService.getU(id);
	      return ResponseEntity.ok().body(Kuser);
	   }

	   /*---get all users---*/
	   @GetMapping("/project")
	   public ResponseEntity<List<Projects>> list() {
	      List<Projects> Kusers = projectService.userlist();
	      return ResponseEntity.ok().body(Kusers);
	   }

	   /*---Update a user by id---*/
	   @PutMapping("/project/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Projects Kuser) {
		   projectService.update(id, Kuser);
	      return ResponseEntity.ok().body("project"+id+" has been updated successfully.");
	   }

	   /*---Delete a user by id---*/
	   @DeleteMapping("/project/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   projectService.deleteU(id);
	      return ResponseEntity.ok().body("project"+id+" has been deleted successfully.");
	   }
//	   
//	   @GetMapping("/project/{id}")
//	   public ResponseEntity<?> getProj
//	   

}
