package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.Aplicacao.DTO.RouteDTO;
import com.dev.trabProjarq.dominio.entities.FlightPlan;
import com.dev.trabProjarq.dominio.entities.Route;
import com.dev.trabProjarq.dominio.services.PlanService;
import com.dev.trabProjarq.dominio.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CancelFlightPlan {
    private PlanService planService;

    @Autowired
    public void cancelFlightPlan(PlanService planService){
        this.planService = planService;
    }

    public FlightPlan cancelaPlano(int id){
        return this.planService.cancelFlightPlan(id);
    }
}
