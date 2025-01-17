package com.redbus.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbus.repository.RedBusRepository;
import com.redbus.servicei.RedBusServiceI;

@Service
public class RedBusServiceImpl implements RedBusServiceI {

	@Autowired
	RedBusRepository rbr;

}
