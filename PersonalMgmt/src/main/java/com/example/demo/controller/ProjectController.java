package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Project;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.service.MapValidationErrorService;
import com.example.demo.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project,BindingResult result) {
		
		ResponseEntity<?> errorMap =mapValidationErrorService.MapValidationService(result);
		if(errorMap!=null) return errorMap;
		projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(project,HttpStatus.CREATED);
	}
	
	@GetMapping("/{projectId}")
	private ResponseEntity<?> getProjectById(@PathVariable String projectId) {
		
		Project project = projectService.findByProjectIdentifer(projectId);
		
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public  Iterable<Project> getAllProjects() {
		return  projectService.getAllProjects();
	}
	
	
	@PatchMapping("")
	public ResponseEntity<?> updateProject(@Valid @RequestBody Project pm) {
		Project project =projectService.saveOrUpdate(pm);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	
	@DeleteMapping("/{projectId}")
	private ResponseEntity<?> deleteProject(@PathVariable String projectId) {
		projectService.deleteProject(projectId.toUpperCase());
		return new ResponseEntity<String>("Project with ID "+projectId+" was deleted successfully",HttpStatus.OK);
		
	}
	
}
