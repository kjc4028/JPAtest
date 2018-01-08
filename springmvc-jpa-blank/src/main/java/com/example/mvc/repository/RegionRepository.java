package com.example.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {

}
