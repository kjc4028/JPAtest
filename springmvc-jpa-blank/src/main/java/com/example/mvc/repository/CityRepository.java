package com.example.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
