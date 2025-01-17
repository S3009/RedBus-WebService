package com.purpletravels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.purpletravels.model.Bus;
import com.purpletravels.servicei.PurpleServiceI;

@RestController
public class PurpleController {

	@Autowired
	PurpleServiceI psi;

	@PostMapping("/saveBus")
	public Bus saveBus(@RequestBody Bus b) {

		Bus bus = psi.saveBus(b);
		return bus;
	}

	@GetMapping("/getBuses")
	public List<Bus> getBuses() {

		List<Bus> list = psi.getBuses();

		return list;
	}

	@GetMapping("/getBusByLocation/{flocation}/{tlocation}")
	public List<Bus> getBusByLocation(@PathVariable("flocation") String fl, @PathVariable("tlocation") String tl) {

		List<Bus> b = psi.getBusByLocation(fl, tl);
		return b;
	}

	@GetMapping("/getBus/{id}")
	public Bus getBus(@PathVariable int id) {

		Bus bus = psi.getBusById(id);
		return bus;
	}

	@PutMapping("/updateBus")
	public Bus updateBus(@RequestBody Bus b) {

		Bus bus = psi.updateBus(b);
		return bus;

	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteBusById(@PathVariable("id") int id) {
		psi.deleteById(id);

	}

}
