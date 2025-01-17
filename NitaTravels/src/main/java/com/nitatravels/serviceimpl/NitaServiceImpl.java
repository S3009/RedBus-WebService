package com.nitatravels.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitatravels.model.Bus;
import com.nitatravels.repository.NitaRepository;
import com.nitatravels.servicei.NitaServiceI;

@Service
public class NitaServiceImpl implements NitaServiceI {

	@Autowired
	NitaRepository nr;

	@Override
	public List<Bus> saveBuses(List<Bus> b) {

		List<Bus> blist = nr.saveAll(b);
		return blist;
	}

	@Override
	public List<Bus> getBuses() {

		return nr.findAll();
	}

	@Override
	public List<Bus> getBus(String fl, String tl, String date) {

		List<Bus> list = nr.findByFlocationAndTolocationAndDate(fl, tl, date);
		return list;
	}

	@Override
	public Bus updateBus(Bus b) {

		Bus bus = nr.save(b);
		return bus;
	}

	@Override
	public void deleteBus(int id) {

		nr.deleteById(id);
	}

	@Override
	public void deleteBuses() {

		nr.deleteAll();
	}

	@Override
	public List<Bus> getBusByLocation(String fl, String tl) {
		List<Bus> list = nr.findByFlocationAndTolocation(fl, tl);
		return list;
	}

}
