package com.example.incidents_api.service;

import org.springframework.stereotype.Service;

import com.example.incidents_api.DTOs.GridCell;
import com.example.incidents_api.DTOs.LookupData;
import com.example.incidents_api.DTOs.StateAgg;
import com.example.incidents_api.DTOs.TimePoint;
import com.example.incidents_api.entity.Incident;
import com.example.incidents_api.repository.IncidentRepository;

import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident getIncident(String uid) {
        return incidentRepository.findById(uid).orElse(null);
    }

    public List<TimePoint> getSeries() {
        // TODO: consulta agregada
        return List.of(new TimePoint("2020-01", 5L, 2L, 3L));
    }

    public List<StateAgg> getAggByState() {
        // TODO: consulta agregada
        return List.of(new StateAgg("TX", 12L, 3L, 15L));
    }

    public List<GridCell> getHeatGrid() {
        // TODO: consulta espacial
        return List.of(new GridCell("9v6knf", 8L));
    }

    public LookupData getLookups() {
        LookupData data = new LookupData();
        data.setStates(List.of("TX", "CA", "FL"));
        data.setSchoolTypes(List.of("High School", "Middle School", "Elementary"));
        data.setShootingTypes(List.of("On campus", "Bus", "Parking"));
        data.setYears(List.of(2018, 2019, 2020, 2021, 2022));
        return data;
    }
}
