package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.Aplicacao.DTO.FlightPlanDTO;
import com.dev.trabProjarq.dominio.entities.FlightPlan;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlansCrud extends JpaRepository<FlightPlan, Integer> {

    List<FlightPlan> findAllPlans();

    FlightPlan findPlanById(int planID);

    FlightPlanDTO savePlan(FlightPlanDTO flightPlanDTO);

    void removePlan(FlightPlan plan);

    FlightPlan findPlanByAeroviaId(int aeroviaId);

    FlightPlan findPlanByAeroviaIdAndRouteId(int aeroviaId, int routeId);

}
