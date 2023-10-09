package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.Aplicacao.DTO.FlightPlanDTO;
import com.dev.trabProjarq.dominio.entities.Airway;
import com.dev.trabProjarq.dominio.entities.FlightPlan;
import com.dev.trabProjarq.dominio.services.PlanService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerifyFlightPlan {

    private PlanService planService;

    @Autowired
    public VerifyFlightPlan(PlanService planService){
        this.planService = planService;
    }

    public List<Airway> verifyFlightPlanList(FlightPlanDTO propostaPlanoDeVoo){
        return this.planService.verificarFlightPlan(propostaPlanoDeVoo);
    }
}
