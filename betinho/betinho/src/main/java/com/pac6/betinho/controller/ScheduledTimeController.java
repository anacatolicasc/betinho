package com.pac6.betinho.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac6.betinho.DAO.IScheduledTime;
import com.pac6.betinho.model.ScheduledTime;

@RestController
@RequestMapping("/scheduledTime")
public class ScheduledTimeController {
	
	@Autowired
	private IScheduledTime scheduledTimeDao;
	
	@GetMapping
	public List<ScheduledTime> findScheduledTime () {
		return (List<ScheduledTime>) scheduledTimeDao.findAll();
	}
	
	@PostMapping
	public ScheduledTime createScheduledTime (@RequestBody ScheduledTime scheduledTime) {
		return scheduledTimeDao.save(scheduledTime);
	}
	
	@PutMapping
	public ScheduledTime updateScheduledTime (@RequestBody ScheduledTime scheduledTime) {
		return scheduledTimeDao.save(scheduledTime);
	}
	
	@DeleteMapping("/{id}")
	public Optional<ScheduledTime> deleteScheduledTime (@PathVariable Long id) {
		Optional<ScheduledTime> scheduledTime = scheduledTimeDao.findById(id);
		scheduledTimeDao.deleteById(id);
		return scheduledTime;
	}
}
