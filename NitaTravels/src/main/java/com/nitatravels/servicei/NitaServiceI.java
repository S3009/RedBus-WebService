package com.nitatravels.servicei;

import java.util.List;

import com.nitatravels.model.Bus;

public interface NitaServiceI {

	List<Bus> saveBuses(List<Bus> b);

	List<Bus> getBuses();

	List<Bus> getBus(String fl, String tl, String date);

	Bus updateBus(Bus b);

	void deleteBus(int id);

	void deleteBuses();

	List<Bus> getBusByLocation(String fl, String tl);

}
