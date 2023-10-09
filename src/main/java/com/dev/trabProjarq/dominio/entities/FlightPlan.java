package com.dev.trabProjarq.dominio.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plano_voo")
public class FlightPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public float altitude;

    public float slot_horario;

    public LocalDate data;

    @ManyToOne
    @JoinColumn( name = "id Aeronave" )
    public Airplane aeronave;

    @ManyToOne
    @JoinColumn( name = "id_rota")
    public Route rota;

    public FlightPlan() {

    }

    public FlightPlan(float slot_horario, LocalDate data, int altitude,Airplane aeronave, Route rota) {
        this.slot_horario = slot_horario;
        this.data = data;
        this.altitude = altitude;
        this.aeronave = aeronave;
        this.rota = rota;
    }
}
