package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRouteCrud extends JpaRepository<Route, Integer> {


}
