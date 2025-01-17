package com.redbus.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redbus.model.Bus;
import com.redbus.servicei.RedBusServiceI;

@RestController
public class RedBusController {

	@Autowired
	RedBusServiceI rbsi;

	@Autowired
	RestTemplate rt;

	@GetMapping("/getAllBuses")
	public Iterable getAllBuses() {
		String url1 = "http://localhost:9091/getBuses";
		Iterable itr1 = rt.getForObject(url1, Iterable.class);

		String url2 = "http://localhost:9092/getBuses";
		Iterable itr2 = rt.getForObject(url2, Iterable.class);

		List al = new ArrayList();
		al.add(itr1);
		al.add(itr2);

		return al;

	}

	@GetMapping("/getByLocation/{flocation}/{tlocation}")
	public Iterable getByLocation(@PathVariable("flocation") String fl, @PathVariable("tlocation") String tl) {

		String url1 = "http://localhost:9091/getBusByLocation" + "/" + fl + "/" + tl;
		Iterable blist1 = rt.getForObject(url1, Iterable.class);

		String url2 = "http://localhost:9092/getBusByLocation" + "/" + fl + "/" + tl;
		Iterable blist2 = rt.getForObject(url2, Iterable.class);

		List list = new ArrayList();
		list.add(blist1);
		list.add(blist2);

		return list;
	}

	@GetMapping("/getSingleBus")
	public List<Bus> getSingleBus() throws IOException {
		String url1 = "http://localhost:9091/getBuses";
		List itr1 = rt.getForObject(url1, List.class);

		String url2 = "http://localhost:9092/getBuses";
		List itr2 = rt.getForObject(url2, List.class);

		List<List<Bus>> al = new ArrayList();
		al.add(itr1);
		al.add(itr2);

		ObjectMapper om = new ObjectMapper();
//
//		for (List<Bus> bb : al) {
//
//			for (Bus o : bb) {
//
//				Bus bus = om.readValue(o, Bus.class);
//			}
//
//		}

		JsonParser jp = om.getFactory().createParser((File) al);

		// Deserialize JSON array into List<Bus> using JsonParser
		List<Bus> buses = om.readValue(jp, new TypeReference<List<Bus>>() {
		});

		return buses;

//		ObjectMapper objectMapper = new ObjectMapper();
//		List<Bus> buses = objectMapper.readValue(al);

//		return null;

//		Iterator<List<Bus>> l1 = al.iterator();
//
//
//		while (l1.hasNext()) {
//			List<Bus> itrbus = l1.next();
//
//			Iterator<Bus> l2 = itrbus.iterator();
//			while (l2.hasNext()) {
//				Bus itrbus2 = l2.next();
//				System.out.println(itrbus2);
//				return itrbus2;
//			}
//		}
//		return null;

	}

}
