package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.AirwayOccupation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirwayOccupationCrud extends JpaRepository<AirwayOccupation, Integer> {

}
