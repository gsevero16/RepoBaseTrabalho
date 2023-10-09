package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.Airway;

import java.util.Optional;

public interface IAirwayRep {
    Optional<Airway> findAirway(int aeroviaId);
}
