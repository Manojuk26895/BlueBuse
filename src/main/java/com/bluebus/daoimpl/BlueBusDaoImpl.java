package com.bluebus.daoimpl;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebus.common.exception.InvalidException;
import com.bluebus.common.exception.RecordNotFoundException;
import com.bluebus.dao.BlueBusDao;
import com.bluebus.model.BlueBus;
import com.bluebus.repo.BlueBusRepo;

@Service
public class BlueBusDaoImpl implements BlueBusDao
{	
	
	@Autowired 
	BlueBusRepo blueBusRepo;
	
	 private boolean isValidVehicleNumber(String Number)
	 {
		 return Pattern.matches("^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$", Number);
	 }
	 
	 private boolean isalphabets(String name)
	 {
		 return Pattern.matches("^[a-zA-Z]*$", name);
	 }

	@Override
	public BlueBus Create(BlueBus blueBus) throws InvalidException
	{
		if(isValidVehicleNumber(blueBus.getVehicleNumber())==false)
		{
			throw new InvalidException("INVALID");
		}
		if(isalphabets(blueBus.getSource())==false)
		{
			throw new InvalidException("INVALID");
		}
		
		if(isalphabets(blueBus.getDestination())==false)
		{
			throw new InvalidException("INVALID");
		}	

		if(blueBus.getNumberOfSeats()>100)
		{
			throw new InvalidException("INVALID");
		}
		blueBus.setBusID(UUID.randomUUID().toString());
		blueBus.setCreatTime(System.currentTimeMillis());
		blueBusRepo.save(blueBus);
		return blueBus;
	}

	@Override
	public List<BlueBus> BusList() throws RecordNotFoundException
	{
		return blueBusRepo.findAll();
	}
	
	
	@Override
	public List<BlueBus> BusGetBySouceAndDestination(String source,String destination) throws RecordNotFoundException
	{
		return blueBusRepo.findBySource(source,destination);
	}

}
