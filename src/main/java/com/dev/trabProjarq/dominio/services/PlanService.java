package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.Aplicacao.DTO.FlightPlanDTO;
import com.dev.trabProjarq.dominio.entities.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {
    private IPlansRep planosRep;
    private IRouteRep rotasRep;
    private IAirwayOccupationRep ocupationRep;
    private IAirplaneRep airplaneRep;

    @Autowired
    public PlanService(IPlansRep planosRep, IRouteRep rotasRep, IAirwayOccupationRep ocupationRep) {
        this.planosRep = planosRep;
        this.rotasRep = rotasRep;
        this.ocupationRep = ocupationRep;
    }

    public List<Airway> verificarFlightPlan(FlightPlanDTO proposalPlan) {
        Route rotaEscolhida = this.rotasRep.findById(proposalPlan.routeID);

        List<Airway> trechosComProblemas = new ArrayList<>();

        for (Airway airway : rotaEscolhida.airways) {
            List<Float> slotsHorarios = new ArrayList<>();

            float tempoVoo = airway.distancia / proposalPlan.cruiserSpeed;

            tempoVoo = tempoVoo + proposalPlan.departureTime;

            slotsHorarios.add((float) Math.floor(proposalPlan.departureTime));

            while (tempoVoo > proposalPlan.departureTime) {
                slotsHorarios.add((float) Math.floor(proposalPlan.departureTime));
                tempoVoo--;
            }

            List<AirwayOccupation> ocupadas = this.ocupationRep.findOcupadasSlots(
                    airway.id,
                    proposalPlan.date,
                    slotsHorarios);
            for (AirwayOccupation ocupation : ocupadas) {
                if (ocupation.slot_altitude == proposalPlan.altitude) {
                    trechosComProblemas.add(airway);
                }
            }
        }

        return trechosComProblemas;
    }

    public FlightPlan cancelFlightPlan(int id) {
        FlightPlan plano = this.planosRep.findPlanById(id);
        if (plano != null) {
            Route route = plano.rota;
            List<Airway> Airways = route.airways;

            for (Airway Airway : Airways) {
                List<Float> slotsHorarios = new ArrayList<>();

                float tempoVoo = Airway.distancia / plano.aeronave.cruiseSpeed;

                for (int i = 0; i < tempoVoo; i++) {
                    slotsHorarios.add((float) Math.floor(plano.slot_horario + i));
                }
                List<AirwayOccupation> slotsOcupados = this.ocupationRep
                        .findOcupadasSlots(Airway.id, plano.data, slotsHorarios).stream()
                        .filter(o -> o.slot_altitude == plano.altitude)
                        .collect(Collectors.toList());

                for (AirwayOccupation slot : slotsOcupados) {
                    this.ocupationRep.removeOccupation(slot);
                }
            }
            this.planosRep.removePlan(plano);
        }

        return plano;
    }

    public FlightPlanDTO authorizeFlightPlan(FlightPlanDTO f) {
        if (this.verificarFlightPlan(f).isEmpty()) {
            Route rota = this.rotasRep.findById(f.routeID);
            Airplane aeronave = this.airplaneRep.findAirplaneById(f.plane.prefixo);
            FlightPlanDTO flightPlan = new FlightPlanDTO(f.routeID, f.date, aeronave.cruiseSpeed,
            f.altitude, 0, aeronave);
            for (Airway Airway : rota.airways) {
                List<Float> slotsHorarios = new ArrayList<>();

                float tempoVoo = Airway.distancia / flightPlan.plane.cruiseSpeed;

                for (int i = 0; i < tempoVoo; i++) {
                    slotsHorarios.add((float) Math.floor(flightPlan.departureTime + i));
                }

                for (float slot : slotsHorarios) {
                    LocalDate date = flightPlan.date;
                    if (slot > 24) {
                        slot = slot - 24;
                        date = date.plusDays(1);
                    }
                    AirwayOccupation ocupationAirway = new AirwayOccupation(date, Airway, (int) flightPlan.altitude,
                            (int) slot);
                    this.ocupationRep.ocupa(ocupationAirway);
                }
            }
            return this.planosRep.savePlan(flightPlan);
        }
        return null;
    }
}
