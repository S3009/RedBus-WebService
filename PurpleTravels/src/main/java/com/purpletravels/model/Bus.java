package com.purpletravels.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bus {

	@Id
	private int id;
	private String companyName;
	private String flocation;
	private String tolocation;
	private String date;
	private String time;
	private String ticketPrice;
	private boolean ac;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFlocation() {
		return flocation;
	}

	public void setFlocation(String flocation) {
		this.flocation = flocation;
	}

	public String getTolocation() {
		return tolocation;
	}

	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

}
