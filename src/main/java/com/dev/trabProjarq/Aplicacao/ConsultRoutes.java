package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.Aplicacao.DTO.RouteDTO;
import com.dev.trabProjarq.dominio.entities.Route;
import com.dev.trabProjarq.dominio.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ConsultRoutes {
    private RouteService servicoRotas;

    @Autowired
    public ConsultRoutes(RouteService servicoRotas) {
        this.servicoRotas = servicoRotas;
    }

    public List<RouteDTO> searchRouteByDestiny(String destino, String origem){
        List<Route> rotasSelecionadas = this.servicoRotas.consultaRotas(destino, origem);
        List<RouteDTO> rotasSelecionadasDto = new ArrayList<>();
        rotasSelecionadas.forEach( rota -> rotasSelecionadasDto.add(new RouteDTO(rota)));
        return rotasSelecionadasDto;
    }

}
