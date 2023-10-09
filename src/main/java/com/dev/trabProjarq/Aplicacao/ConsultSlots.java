package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.dominio.services.AirwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsultSlots {
    private AirwayService servicoDeAerovias;

    @Autowired
    public ConsultSlots(AirwayService servicoDeAerovias) {
        this.servicoDeAerovias = servicoDeAerovias;
    }

    public List<Integer> consultaAltitudesLivres(int aeroviaId, LocalDate data, Float horario, float velCruzeiro){
        return this.servicoDeAerovias.consultaSlotsLivres(aeroviaId, data, horario, velCruzeiro);
    }
}
