package com.dev.trabProjarq.Aplicacao.DTO;

import java.util.List;

public class ReportDTO {
    
    public List<OccupationPercentageDTO> listaOcupacao;
    
    public ReportDTO(List<OccupationPercentageDTO> listaOcupacao){
        this.listaOcupacao = listaOcupacao;
    }

}
