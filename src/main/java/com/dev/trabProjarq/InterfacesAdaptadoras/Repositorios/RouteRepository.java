package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.Route;
import com.dev.trabProjarq.dominio.services.IRouteRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteRepository implements IRouteRep{
    private IRouteCrud routeCrud;

    @Autowired
    public RouteRepository(IRouteCrud routeCrud){
        this.routeCrud = routeCrud;
    }

    @Override
    public Route findById(int rotaId) {
        return this.routeCrud.findById(rotaId).get();
    }

    @Override
    public List<Route> findRoutes(){
        return this.routeCrud.findAll();
    }

}
