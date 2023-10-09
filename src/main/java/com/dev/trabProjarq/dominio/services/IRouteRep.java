package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.Route;

import java.util.List;

public interface IRouteRep{
    Route findById(int routeID);
    List<Route> findRoutes();
}
