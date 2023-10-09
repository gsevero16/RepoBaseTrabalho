package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.AirwayOccupation;

import java.time.LocalDate;
import java.util.List;

public interface IAirwayOccupationRep {
    List<AirwayOccupation> findOcupadasSlots(int airwayID, LocalDate date, List<Float> slotsTimes);
    List<AirwayOccupation> findAllAirwaysOccupiedByDate(int airwayID, LocalDate date);

    AirwayOccupation ocupa(AirwayOccupation airwayOccupation);

    void removeOccupation(AirwayOccupation airwayOccupation);
}
