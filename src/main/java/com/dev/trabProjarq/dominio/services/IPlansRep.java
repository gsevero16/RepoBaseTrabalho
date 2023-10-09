package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.Aplicacao.DTO.FlightPlanDTO;
import com.dev.trabProjarq.dominio.entities.FlightPlan;

import java.util.List;

public interface IPlansRep {
    List<FlightPlan> findPlans();

    FlightPlanDTO savePlan(FlightPlanDTO flightPlanDTO);

    FlightPlan findPlanById(int planID);

    void removePlan(FlightPlan plan);
}

