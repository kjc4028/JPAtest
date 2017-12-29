package com.example.mvc.service;

import org.springframework.data.domain.Page;

import com.example.mvc.entity.Teams;

public interface TeamsService {
	
	Page<Teams> findAll(int page, int size);
	
	Teams findById(int id);
	
	Teams insert(Teams teams);

	Teams update(Teams teams);

	void delete(Integer teamId);
}