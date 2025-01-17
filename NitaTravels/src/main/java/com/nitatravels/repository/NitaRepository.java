package com.nitatravels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitatravels.model.Bus;

@Repository
public interface NitaRepository extends JpaRepository<Bus, Integer> {

	List<Bus> findByFlocationAndTolocationAndDate(String flocation, String tl, String date);

	void deleteById(int id);

	List<Bus> findByFlocationAndTolocation(String flocation, String tl);

}
