package com.dev.trabProjarq.Aplicacao.DTO;
import java.time.LocalDate;

import com.dev.trabProjarq.dominio.entities.Airplane;

public class FlightPlanDTO {
    public int routeID;

    public LocalDate date;

    public float departureTime;

    public float cruiserSpeed;

    public int altitude;

    public Airplane plane;

    public FlightPlanDTO(int routeID, LocalDate date, float departureTime, float cruiserSpeed, int altitude, Airplane plane) {
        this.routeID = routeID;
        this.date = date;
        this.departureTime = departureTime;
        this.cruiserSpeed = cruiserSpeed;
        this.altitude = altitude;
        this.plane = plane;
    }
}