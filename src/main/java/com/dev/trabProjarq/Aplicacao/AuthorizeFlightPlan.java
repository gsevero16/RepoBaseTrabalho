package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.Aplicacao.DTO.FlightPlanDTO;
import com.dev.trabProjarq.dominio.entities.Airway;
import com.dev.trabProjarq.dominio.entities.FlightPlan;
import com.dev.trabProjarq.dominio.services.PlanService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizeFlightPlan {

    private PlanService planService;

    @Autowired
    public AuthorizeFlightPlan(PlanService planService){
        this.planService = planService;
    }

    public FlightPlanDTO autorizaPlanoDeVoo(FlightPlanDTO planoVoo){
        return this.planService.authorizeFlightPlan(planoVoo);
    }
}
