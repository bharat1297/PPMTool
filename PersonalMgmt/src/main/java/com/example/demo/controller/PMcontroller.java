package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PM;
import com.example.demo.service.PMservice;

@RestController
public class PMcontroller {
	
	@Autowired
	PMservice pmservice;
	
	@GetMapping("/getProject")
	private List<PM> getProjects() {
		return pmservice.getProjects();
	}
	
	@GetMapping("/getProject/{projectId}")
	private PM getProjectById(@PathVariable Long id) {
		return pmservice.getProjectsById(id);
	}
	
	@PostMapping("/project")
	private Long createProject(@RequestBody PM pm) {
		PM pm1 =pmservice.saveOrUpdate(pm);
		return pm1.getId();
	}
	
	@PutMapping("/project")
	private Long updateProject(@RequestBody PM pm) {
		PM pm1 =pmservice.saveOrUpdate(pm);
		return pm1.getId();
		
	}
	
	@DeleteMapping("/project")
	private void deleteProject(@PathVariable("projectId")Long projectId) {
		pmservice.delete(projectId);
	}
	
}
