package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.Airway;
import com.dev.trabProjarq.dominio.services.IAirwayRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AirwayRepository implements IAirwayRep {
	private IAirwayCrud airwayCrud;

	@Autowired
	public AirwayRepository(IAirwayCrud airwayCrud) {
		this.airwayCrud = airwayCrud;
	}

	@Override
	public Optional<Airway> findAirway(int aeroviaId) {
		return this.airwayCrud.findById(aeroviaId);
	}

}
