package com.dev.trabProjarq.dominio.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Table(name = "ocupacao_airway")
public class AirwayOccupation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_airway")
    public Airway airway;

    public int slot_altitude;

    public int slot_horario;

    public Object airwayaux;

    public AirwayOccupation() {

    }

    public AirwayOccupation(LocalDate data, Airway airway, int slot_altitude, int slot_horario) {
        this.data = data;
        this.airway = airway;
        this.slot_altitude = slot_altitude;
        this.slot_horario = slot_horario;
    }
}