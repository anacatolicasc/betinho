package com.pac6.betinho.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pac6.betinho.model.CurrentQuantity;
import com.pac6.betinho.service.CurrentQuantityService;
import com.pac6.betinho.service.UserService;

@RestController
@RequestMapping("/currentQuantity")
public class CurrentQuantityController {
	
	private CurrentQuantityService currentQuantityService;
	private UserService userService;
	
	public CurrentQuantityController(CurrentQuantityService currentQuantityService, UserService userService) {
		this.currentQuantityService = currentQuantityService;
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<CurrentQuantity>> findCurrentQuantity () {
		return ResponseEntity.status(200).body(currentQuantityService.list());
	}
	
	@PostMapping("/create")
	public ResponseEntity<CurrentQuantity> createCurrentQuantity (@RequestBody CurrentQuantity currentQuantity, @RequestParam String token) {
        Long userId = userService.getUserByToken(token);
        
        if (userService.userExists(userId)) {
            currentQuantity.setUser(userService.getUserById(userId));
            CurrentQuantity createdCurrentQuantity = currentQuantityService.create(currentQuantity);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCurrentQuantity);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
	}
	
	@PutMapping
	public ResponseEntity<CurrentQuantity> updateScheduledTime (@RequestBody CurrentQuantity currentQuantity) {
		return ResponseEntity.status(201).body(currentQuantityService.update(currentQuantity));
	}
}
