package com.dev.trabProjarq.dominio.entities;

import javax.persistence.*;

@Entity
@Table(name = "airplane")
public class Airplane {

    @Id
    public int prefixo;

    public String tipe;

    public float cruiseSpeed;

    public double autonomy;

    public Airplane(){

    }
}
