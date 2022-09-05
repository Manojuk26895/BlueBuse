package com.bluebus.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bluebus.model.BlueBus;

@Repository
public interface BlueBusRepo extends JpaRepository<BlueBus, String>{

	@Query(value="SELECT * FROM BlueBus WHERE source:'?0',destination:'?1'")
	List<BlueBus> findBySource(String source, String destination);

}
