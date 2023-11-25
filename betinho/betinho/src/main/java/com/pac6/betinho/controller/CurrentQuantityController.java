package com.pac6.betinho.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac6.betinho.model.CurrentQuantity;
import com.pac6.betinho.service.CurrentQuantityService;

@RestController
@RequestMapping("/currentQuantity")
public class CurrentQuantityController {
	
	private CurrentQuantityService currentQuantityService;
	
	public CurrentQuantityController(CurrentQuantityService currentQuantityService) {
		this.currentQuantityService = currentQuantityService;
	}
	
	@GetMapping
	public ResponseEntity<List<CurrentQuantity>> findCurrentQuantity () {
		return ResponseEntity.status(200).body(currentQuantityService.list());
	}
	
	@PostMapping
	public ResponseEntity<CurrentQuantity> createCurrentQuantity (@RequestBody CurrentQuantity currentQuantity) {
		return ResponseEntity.status(201).body(currentQuantityService.create(currentQuantity));
	}
	
	@PutMapping
	public ResponseEntity<CurrentQuantity> updateScheduledTime (@RequestBody CurrentQuantity currentQuantity) {
		return ResponseEntity.status(201).body(currentQuantityService.update(currentQuantity));
	}
}
