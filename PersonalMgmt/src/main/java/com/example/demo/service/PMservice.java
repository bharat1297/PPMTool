package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PM;
import com.example.demo.repository.PMrepository;

@Service
public class PMservice {

	@Autowired
	PMrepository pmRepo;
	
	public List<PM> getProjects() {
		List<PM> projects = new ArrayList<PM>();
		pmRepo.findAll().forEach(record ->projects.add(record));
		return projects;
	}

	public PM getProjectsById(Long id) {
		return pmRepo.findById(id).get();
	}

	public PM saveOrUpdate(PM pm) {
		// TODO Auto-generated method stub
		return pmRepo.save(pm);
	}

	public void delete(Long projectId) {
		pmRepo.deleteById(projectId);
	}

	

	
	
}
