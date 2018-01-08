package com.example.mvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.City;
import com.example.mvc.repository.CityRepository;
import com.example.mvc.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	@Inject
	protected CityRepository cityRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<City> findAll(){
		return cityRepository.findAll();
	}

}
