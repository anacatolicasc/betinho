package com.pac6.betinho.DAO;

import org.springframework.data.repository.CrudRepository;

import com.pac6.betinho.model.ScheduledTime;

public interface IScheduledTime extends CrudRepository<ScheduledTime, Long> {

}
