package com.bluebus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluebus.common.exception.InvalidException;
import com.bluebus.common.exception.RecordNotFoundException;
import com.bluebus.dao.BlueBusDao;
import com.bluebus.model.BlueBus;

@RestController
@RequestMapping("/bluebuse")
public class BlueBusController 
{
	@Autowired
	BlueBusDao blueBusDao;
	
	@PostMapping(value = "/create")
	public BlueBus Create(@RequestBody BlueBus blueBus) throws InvalidException 
	{
		return blueBusDao.Create(blueBus);
	}

	@GetMapping(value = "/list")
	public List<BlueBus> BusList() throws RecordNotFoundException 
	{
		return blueBusDao.BusList();
	}
	
	@GetMapping(value = "/listbysouce")
	public List<BlueBus> BusGetBySouceAndDestination(@RequestParam String source,@RequestParam String destination) throws RecordNotFoundException 
	{
		return BusGetBySouceAndDestination(source,destination);
	}

}
