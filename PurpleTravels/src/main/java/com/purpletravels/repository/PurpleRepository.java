package com.purpletravels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purpletravels.model.Bus;

@Repository
public interface PurpleRepository extends JpaRepository<Bus, Integer> {

	List<Bus> findByFlocationAndTolocation(String fl, String tl);
}
