package com.dev.trabProjarq.InterfacesAdaptadoras;

import com.dev.trabProjarq.Aplicacao.*;
import com.dev.trabProjarq.Aplicacao.DTO.FlightPlanDTO;
import com.dev.trabProjarq.Aplicacao.DTO.ReportDTO;
import com.dev.trabProjarq.Aplicacao.DTO.RouteDTO;
import com.dev.trabProjarq.dominio.entities.Airway;
import com.dev.trabProjarq.dominio.entities.FlightPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/menuTraffic")
public class AirwayTrafficMenu {
    private ConsultRoutes routeConsult;
    private ConsultSlots slotsConsult;
    private GenerateReport generateReport;

    private VerifyFlightPlan verifyFlightPlan;

    private AuthorizeFlightPlan authorizeFlightPlan;

    private CancelFlightPlan cancelFlightPlan;

    @Autowired
    public AirwayTrafficMenu(ConsultRoutes routeConsult, ConsultSlots slotsConsult,
            VerifyFlightPlan verifyFlightPlan, AuthorizeFlightPlan authorizeFlightPlan,
            CancelFlightPlan cancelFlightPlan, GenerateReport generateReport) {
        this.generateReport = generateReport;
        this.routeConsult = routeConsult;
        this.slotsConsult = slotsConsult;
        this.verifyFlightPlan = verifyFlightPlan;
        this.authorizeFlightPlan = authorizeFlightPlan;
        this.cancelFlightPlan = cancelFlightPlan;
    }

    @GetMapping("/routes")
    @CrossOrigin(origins = "*")
    public List<RouteDTO> consultaRotasDestinos(@RequestParam("destination") String destination,
            @RequestParam("origin") String origin) {
        return this.routeConsult.searchRouteByDestiny(destination, origin);
    }

    @GetMapping("/altitudes-free/{airwayID}")
    @CrossOrigin(origins = "*")
    public List<Integer> consultAltitudesFree(@PathVariable int airwayID, @RequestParam("date") String date,
            @RequestParam("time") float time, @RequestParam("velocidade") float cruiseSpeed) {
        LocalDate dateObj = LocalDate.parse(date);
        return this.slotsConsult.consultaAltitudesLivres(airwayID, dateObj, time, cruiseSpeed);
    }

    @PostMapping("/verify-flight-plan")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Airway>> verifyFlightPlan(@RequestBody FlightPlanDTO flightPlan) {
        List<Airway> list = this.verifyFlightPlan.verifyFlightPlanList(flightPlan);

        if (!list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/release-plan")
    @CrossOrigin(origins = "*")
    public ResponseEntity<FlightPlanDTO> releasePlan(@RequestBody FlightPlanDTO flightPlan) {
        FlightPlanDTO plano = this.authorizeFlightPlan.autorizaPlanoDeVoo(flightPlan);
        if (plano != null) {
            return ResponseEntity.status(HttpStatus.OK).body(plano);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/cancel-plan/{planID}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<FlightPlan> cancelaPlano(@PathVariable int planID) {
        FlightPlan plano = this.cancelFlightPlan.cancelaPlano(planID);

        if (plano == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(plano);
        }
        return ResponseEntity.status(HttpStatus.OK).body(plano);
    }

    @GetMapping("/report/{airwayID}")
    @CrossOrigin(origins = "*")
    public ReportDTO generateReport(@PathVariable int airwayID, @RequestParam("date") String date) {
        LocalDate dateObj = LocalDate.parse(date);
        return this.generateReport.geraRelatorio(airwayID, dateObj);
    }
}
