package com.pac6.betinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pac6.betinho.model.ScheduledTime;
import com.pac6.betinho.repository.ScheduledTimeRepository;

@Service
public class ScheduledTimeService {
	
	private ScheduledTimeRepository repository;
	
	@Autowired
	public ScheduledTimeService(ScheduledTimeRepository repository) {
		this.repository = repository;
	}
	
	public List<ScheduledTime> list() {
		List<ScheduledTime> lista = repository.findAll();
		return lista;
	}
	
	public ScheduledTime create(ScheduledTime ScheduledTime) {
		ScheduledTime newScheduledTime = repository.save(ScheduledTime);
		return newScheduledTime;
	}
	
	public ScheduledTime update(ScheduledTime ScheduledTime) {
		ScheduledTime newScheduledTime = repository.save(ScheduledTime);
		return newScheduledTime;
	}
	
	public List<ScheduledTime> findByUserId(Long id) {
	    return repository.findByUserId(id);
	}

}
