package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.Airway;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirwayCrud extends JpaRepository<Airway, Integer> {

    Optional<Airway> findAirway(int aeroviaId);
    List<Airway> findAllAirways();

}
