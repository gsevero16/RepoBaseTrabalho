package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.AirwayOccupation;
import com.dev.trabProjarq.dominio.services.IAirwayOccupationRep;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirwayOccupationRepository implements IAirwayOccupationRep {
	private IAirwayOccupationCrud airwayOccupationCrud;

	@Autowired
	public AirwayOccupationRepository(IAirwayOccupationCrud airwayOccupationCrud) {
		this.airwayOccupationCrud = airwayOccupationCrud;
	}

	@Override
	public List<AirwayOccupation> findOcupadasSlots(int airwayId, LocalDate date, List<Float> timeSlots) {
		return airwayOccupationCrud.findAll().stream()
		.filter(oa -> oa.airway.id == airwayId)
		.filter(oa -> oa.data.equals(date))
		.filter(oa -> timeSlots.contains((float) oa.slot_horario))
		.collect(Collectors.toList());
	}

	@Override
	public AirwayOccupation ocupa(AirwayOccupation occupationAirway){
		return airwayOccupationCrud.save(occupationAirway);
	}

	@Override
	public void removeOccupation(AirwayOccupation occupationAirway) {
		this.airwayOccupationCrud.delete(occupationAirway);
	}

	@Override
	public List<AirwayOccupation> findAllAirwaysOccupiedByDate(int airwayId, LocalDate date){
		return airwayOccupationCrud.findAll().stream().filter(oa -> oa.airway.id == airwayId)
		.filter(oa -> oa.data.equals(date))
		.collect(Collectors.toList());
	}

}
