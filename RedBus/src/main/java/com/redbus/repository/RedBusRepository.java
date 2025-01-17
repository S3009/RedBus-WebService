package com.redbus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redbus.model.Bus;

@Repository
public interface RedBusRepository extends JpaRepository<Bus, Integer> {

}
