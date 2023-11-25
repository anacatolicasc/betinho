package com.pac6.betinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac6.betinho.model.ScheduledTime;

@Repository
public interface IScheduledTime extends JpaRepository<ScheduledTime, Long> {

}
