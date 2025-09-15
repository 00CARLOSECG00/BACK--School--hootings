package com.example.incidents_api.controller;


import org.springframework.web.bind.annotation.*;

import com.example.incidents_api.DTOs.GridCell;
import com.example.incidents_api.DTOs.LookupData;
import com.example.incidents_api.DTOs.StateAgg;
import com.example.incidents_api.DTOs.TimePoint;
import com.example.incidents_api.entity.Incident;
import com.example.incidents_api.service.IncidentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping("/incidents")
    public List<Incident> getIncidents(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) String state
    ) {
        return incidentService.getAllIncidents();
    }

    @GetMapping("/incidents/{uid}")
    public Incident getIncident(@PathVariable String uid) {
        return incidentService.getIncident(uid);
    }

    @GetMapping("/stats/series")
    public List<TimePoint> getSeries() {
        return incidentService.getSeries();
    }

    @GetMapping("/stats/by-state")
    public List<StateAgg> getAggByState() {
        return incidentService.getAggByState();
    }

    @GetMapping("/stats/heat")
    public List<GridCell> getHeatGrid() {
        return incidentService.getHeatGrid();
    }

    @GetMapping("/lookups")
    public LookupData getLookups() {
        return incidentService.getLookups();
    }
}
