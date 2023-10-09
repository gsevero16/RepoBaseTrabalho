package com.dev.trabProjarq.dominio.services;
import java.util.*;

import com.dev.trabProjarq.dominio.entities.Airplane;


public interface IAirplaneRep {
    List<Airplane> airplanes();

    Airplane findAirplaneById(int airwayID);

}
