package com.example.mvc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.City;
import com.example.mvc.service.CityService;

@Service
public class RegionServiceImpl implements CityService {

	@Override
	@Transactional(readOnly=true)
	public List<City> findAll() {
		return null;
	}

}
