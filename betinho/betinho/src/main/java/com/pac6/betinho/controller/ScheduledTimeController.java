package com.pac6.betinho.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pac6.betinho.model.ScheduledTime;
import com.pac6.betinho.service.ScheduledTimeService;
import com.pac6.betinho.service.UserService;

@RestController
@RequestMapping("/scheduledTime")
public class ScheduledTimeController {
	
	private ScheduledTimeService scheduledTimeService;
	
	private UserService userService;
	
	public ScheduledTimeController(ScheduledTimeService scheduledTimeService, UserService userService) {
		this.scheduledTimeService = scheduledTimeService;
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ScheduledTime>> findScheduledTime(@RequestParam String token) {
	    Long userId = userService.getUserByToken(token);
	    List<ScheduledTime> scheduledTimes = scheduledTimeService.findByUserId(userId);
	    
	    if (scheduledTimes != null && !scheduledTimes.isEmpty()) {
	    	scheduledTimes.forEach(scheduledTime -> scheduledTime.setUser(null));
	        return ResponseEntity.status(200).body(scheduledTimes);
	    } else {
	        return ResponseEntity.status(404).build();
	    }
	}
	
	@PostMapping
	public ResponseEntity<ScheduledTime> createScheduledTime (@RequestBody ScheduledTime scheduledTime, @RequestParam String token) {
		return ResponseEntity.status(201).body(scheduledTimeService.create(scheduledTime));
	}
	
	@PutMapping
	public ResponseEntity<ScheduledTime> updateScheduledTime (@RequestBody ScheduledTime scheduledTime) {
		return ResponseEntity.status(201).body(scheduledTimeService.update(scheduledTime));
	}
}
