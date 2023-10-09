package com.dev.trabProjarq.Aplicacao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.trabProjarq.Aplicacao.DTO.ReportDTO;
import com.dev.trabProjarq.dominio.services.AirwayService;

@Component
public class GenerateReport {
    private AirwayService servicoDeAerovias;

    @Autowired
    public GenerateReport(AirwayService servicoDeAerovias) {
        this.servicoDeAerovias = servicoDeAerovias;
    }

    public ReportDTO geraRelatorio(int aeroviaId, LocalDate data){
        return this.servicoDeAerovias.consultaPorcentagemOcupacao(aeroviaId, data);
    }
}
