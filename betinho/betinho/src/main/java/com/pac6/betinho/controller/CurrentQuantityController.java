package com.pac6.betinho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac6.betinho.DAO.ICurrentQuantity;
import com.pac6.betinho.model.CurrentQuantity;

@RestController
@RequestMapping("/currentQuantity")
public class CurrentQuantityController {

	@Autowired
	private ICurrentQuantity currentQuantityDao;
	
	@GetMapping
	public List<CurrentQuantity> findCurrentQuantity () {
		return (List<CurrentQuantity>) currentQuantityDao.findAll();
	} 
	
	@PostMapping
	public CurrentQuantity createCurrentQuantity (@RequestBody CurrentQuantity currentQuantity) {
		return currentQuantityDao.save(currentQuantity);
	}
	
	@PutMapping
	public CurrentQuantity updateScheduledTime (@RequestBody CurrentQuantity currentQuantity) {
		return currentQuantityDao.save(currentQuantity);
	}
}
