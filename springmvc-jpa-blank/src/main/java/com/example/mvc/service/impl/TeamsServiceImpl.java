package com.example.mvc.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.Person;
import com.example.mvc.entity.Teams;
import com.example.mvc.repository.TeamsRepository;
import com.example.mvc.service.TeamsService;

@Service
public class TeamsServiceImpl implements TeamsService {
	@Inject
	protected TeamsRepository teamsRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Teams> findAll(int page, int size) {
		Sort sort = new Sort(Direction.DESC, "teamId");
		Pageable pageable = new PageRequest(page, size, sort);
		Page<Teams> teams = teamsRepository.findAll(pageable);
		return teams;
	}

	@Override
	@Transactional	
	public Teams insert(Teams teams) {
		return teamsRepository.save(teams);
	}

	@Override
	@Transactional
	public Teams update(Teams teams) {
		return teamsRepository.save(teams);
	}

	@Override
	@Transactional
	public void delete(Integer teamId) {
		teamsRepository.delete(teamId);
	}

	@Override
	@Transactional(readOnly = true)
	public Teams findById(int id) {
		return teamsRepository.findById(id);
	}

	@Override
	@Transactional
	public Long countByTeamName(String teamName) {
		return teamsRepository.countByTeamName(teamName);
	}

	@Override
	@Transactional(readOnly=true)
	public Teams join() {
		return teamsRepository.join();
	}



}
