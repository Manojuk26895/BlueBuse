package com.bluebus.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class BlueBus 
{
	@Id
	private String busID;
	private String busRoute;
	private String vehicleNumber;
	private String source;
	private String destination;
	private double Price;
	private double numberOfSeats;	
	private long creatTime;
}
