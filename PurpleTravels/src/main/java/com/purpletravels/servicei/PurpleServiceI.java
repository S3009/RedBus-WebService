package com.purpletravels.servicei;

import java.util.List;

import com.purpletravels.model.Bus;

public interface PurpleServiceI {

	Bus saveBus(Bus b);

	List<Bus> getBuses();

	Bus getBusById(int id);

	Bus updateBus(Bus b);

	void deleteById(int id);

	List<Bus> getBusByLocation(String fl, String tl);

}
