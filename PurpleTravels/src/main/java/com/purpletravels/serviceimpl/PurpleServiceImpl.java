package com.purpletravels.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purpletravels.model.Bus;
import com.purpletravels.repository.PurpleRepository;
import com.purpletravels.servicei.PurpleServiceI;

@Service
public class PurpleServiceImpl implements PurpleServiceI {

	@Autowired
	PurpleRepository pr;

	@Override
	public Bus saveBus(Bus b) {
		Bus bus = pr.save(b);
		return bus;
	}

	@Override
	public List<Bus> getBuses() {
		List<Bus> list = pr.findAll();
		return list;
	}

	@Override
	public Bus getBusById(int id) {

		Optional<Bus> bus = pr.findById(id);
		if (bus.isPresent()) {
			Bus b = bus.get();
			return b;
		}
		return null;
	}

	@Override
	public Bus updateBus(Bus b) {

		Bus bus = pr.save(b);
		return bus;
	}

	@Override
	public void deleteById(int id) {
		pr.deleteById(id);

	}

	@Override
	public List<Bus> getBusByLocation(String fl, String tl) {
		List<Bus> list = pr.findByFlocationAndTolocation(fl, tl);
		return list;
	}

}
