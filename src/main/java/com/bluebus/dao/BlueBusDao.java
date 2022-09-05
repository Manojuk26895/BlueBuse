package com.bluebus.dao;

import java.util.List;

import com.bluebus.common.exception.InvalidException;
import com.bluebus.common.exception.RecordNotFoundException;
import com.bluebus.model.BlueBus;

public interface BlueBusDao {

	BlueBus Create(BlueBus blueBus) throws InvalidException;

	java.util.List<BlueBus> BusList() throws RecordNotFoundException;

	List<BlueBus> BusGetBySouceAndDestination(String source, String destination) throws RecordNotFoundException;

}
