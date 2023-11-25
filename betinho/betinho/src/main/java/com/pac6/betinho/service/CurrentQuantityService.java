package com.pac6.betinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pac6.betinho.model.CurrentQuantity;
import com.pac6.betinho.repository.ICurrentQuantity;

@Service
public class CurrentQuantityService {

	private ICurrentQuantity repository;
	
	@Autowired
	public CurrentQuantityService(ICurrentQuantity repository) {
		this.repository = repository;
	}
	
	public List<CurrentQuantity> list() {
		List<CurrentQuantity> lista = repository.findAll();
		return lista;
	}
	
	public CurrentQuantity create(CurrentQuantity currentQuantity) {
		CurrentQuantity newCurrentQuantity = repository.save(currentQuantity);
		return newCurrentQuantity;
	}
	
	public CurrentQuantity update(CurrentQuantity currentQuantity) {
		CurrentQuantity newCurrentQuantity = repository.save(currentQuantity);
		return newCurrentQuantity;
	}
}
