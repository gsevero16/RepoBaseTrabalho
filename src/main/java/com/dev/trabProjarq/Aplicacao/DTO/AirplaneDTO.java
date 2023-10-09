package com.dev.trabProjarq.Aplicacao.DTO;



public class AirplaneDTO {

    public int prefixo;

    public String tipe;

    public float cruiseSpeed;

    public double autonomy;

    public AirplaneDTO(int prefixo, String tipe, float cruiseSpeed, double autonomy) {
        this.prefixo = prefixo;
        this.tipe = tipe;
        this.cruiseSpeed = cruiseSpeed;
        this.autonomy = autonomy;
    }

}
