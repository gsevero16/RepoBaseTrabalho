package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.Aplicacao.DTO.FlightPlanDTO;
import com.dev.trabProjarq.dominio.entities.FlightPlan;
import com.dev.trabProjarq.dominio.entities.Route;
import com.dev.trabProjarq.dominio.services.IPlansRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlansRepository implements IPlansRep {
	private IPlansCrud plansCrud;

	@Autowired
	public PlansRepository(IPlansCrud plansCrud) {
		this.plansCrud = plansCrud;
	}

	@Override
	public List<FlightPlan> findPlans() {
		return this.plansCrud.findAll();
	}

	@Override
	public FlightPlan findPlanById(int planId) {
		return this.plansCrud.findById(planId).get();
	}

	@Override
	public FlightPlanDTO savePlan(FlightPlanDTO f) {
		return this.plansCrud.savePlan(f);
	}

	@Override
	public void removePlan(FlightPlan plan) {
		this.plansCrud.delete(plan);
	}
}
