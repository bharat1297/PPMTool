package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ProjectIdException;
import com.example.demo.model.Project;
import com.example.demo.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project) {
		try {
			project.setProjectIdentifer(project.getProjectIdentifer().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException("Project '"+project.getProjectIdentifer().toUpperCase()+"'already exists"); 
		}
	}
	
	public Project findByProjectIdentifer(String projectId) {
		Project project = projectRepository.findByProjectIdentifer(projectId.toUpperCase());
		if(project==null) {
			throw new ProjectIdException("Project ID '"+projectId +"' doesn't exist");
		}
		return project; 
	}
	
	public Iterable<Project> getAllProjects() {
		return projectRepository.findAll();
	}


	public void deleteProject(String projectId) {
		Project project = projectRepository.findByProjectIdentifer(projectId);
		
		if(project==null) {
			throw new ProjectIdException("Project ID '"+projectId +"' doesn't exist so cant delete");
		}
		projectRepository.delete(project);
	}

	
	public Project updateProject(String projectId) {
	Project project = projectRepository.findByProjectIdentifer(projectId);
	
	if(project==null) {
		throw new ProjectIdException("Project ID '"+projectId +"' doesn't exist so cant update");
	}
		return projectRepository.save(project);
	}
	
	
}
