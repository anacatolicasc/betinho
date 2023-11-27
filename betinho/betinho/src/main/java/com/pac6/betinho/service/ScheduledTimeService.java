package com.pac6.betinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pac6.betinho.model.ScheduledTime;
import com.pac6.betinho.repository.ScheduledTimeRepository;

@Service
public class ScheduledTimeService {
	
	private ScheduledTimeRepository repository;
	
	private UserService userService;
	
	@Autowired
	public ScheduledTimeService(ScheduledTimeRepository repository, UserService userService) {
		this.repository = repository;
		this.userService = userService;
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
	
	public ResponseEntity<List<ScheduledTime>> findScheduledTimeByUserId(String token) {
        Long userId = userService.getUserByToken(token);
        List<ScheduledTime> scheduledTimes = findByUserId(userId);

        if (scheduledTimes != null && !scheduledTimes.isEmpty()) {
            scheduledTimes.forEach(scheduledTime -> scheduledTime.setUser(null));
            return ResponseEntity.status(HttpStatus.OK).body(scheduledTimes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
