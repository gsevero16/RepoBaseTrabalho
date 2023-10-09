package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {
    private IRouteRep rotasRep;

    @Autowired
    public RouteService(IRouteRep rotasRep) {
        this.rotasRep = rotasRep;
    }

    public List<Route> consultaRotas(String origem, String destino) {
        return rotasRep.findRoutes().stream()
                .filter(rota -> rota.destino.nome.toLowerCase().equals(destino.toLowerCase())
                        && rota.origem.nome.toLowerCase().equals(origem.toLowerCase()))
                .collect(Collectors.toList());
    }
}
