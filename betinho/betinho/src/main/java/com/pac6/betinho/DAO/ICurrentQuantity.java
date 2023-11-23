package com.pac6.betinho.DAO;

import org.springframework.data.repository.CrudRepository;

import com.pac6.betinho.model.CurrentQuantity;

public interface ICurrentQuantity extends CrudRepository<CurrentQuantity, Long> {

}
