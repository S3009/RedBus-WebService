package com.nitatravels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitatravels.model.Bus;
import com.nitatravels.servicei.NitaServiceI;

@RestController
public class NitaController {

	@Autowired
	NitaServiceI nsi;

	@PostMapping("/saveBuses")
	public List<Bus> saveBuses(@RequestBody List<Bus> b) {

		List<Bus> blist = nsi.saveBuses(b);
		return blist;

	}

	@GetMapping("/getBuses")
	public List<Bus> getBuses() {
		List<Bus> list = nsi.getBuses();

		return list;
	}

	@GetMapping("/getBus/{flocation}/{tlocation}/{date}")
	public List<Bus> getBus(@PathVariable("flocation") String fl, @PathVariable("tlocation") String tl,
			@PathVariable("date") String date) {

		List<Bus> b = nsi.getBus(fl, tl, date);
		return b;
	}

	@GetMapping("/getBusByLocation/{flocation}/{tlocation}")
	public List<Bus> getBusByLocation(@PathVariable("flocation") String fl, @PathVariable("tlocation") String tl) {

		List<Bus> b = nsi.getBusByLocation(fl, tl);
		return b;
	}

	@PutMapping("/updateBus")
	public Bus updateBus(@RequestBody Bus b) {

		Bus bus = nsi.updateBus(b);
		return bus;
	}

	@DeleteMapping("/deleteBus/{id}")
	public void deleteBus(@PathVariable("id") int id) {
		nsi.deleteBus(id);

	}

	@DeleteMapping("/deleteBuses")
	public void deleteBuses() {
		nsi.deleteBuses();
	}

}
