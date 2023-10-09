package com.dev.trabProjarq.Aplicacao.DTO;

import java.util.List;

import com.dev.trabProjarq.dominio.entities.Airway;
import com.dev.trabProjarq.dominio.entities.Route;

public class RouteDTO {
    private String nome;
    private int id;
    private List<Airway> airways;

    public RouteDTO(String nome, int id, List<Airway> airways) {
        this.nome = nome;
        this.id = id;
        this.airways = airways;
    }

    public RouteDTO(Route rota) {
        this.nome = rota.nome;
        this.id = rota.id;
        this.airways = rota.airways;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Airway> getairways() {
        return airways;
    }

    public void setairways(List<Airway> airways) {
        this.airways = airways;
    }

}
