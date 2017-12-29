package com.example.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.entity.Teams;

public interface TeamsRepository extends JpaRepository<Teams, Integer> {
	Teams findById(int id);
}
