package com.example.incidents_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.incidents_api.entity.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, String> {
    // Podrás agregar métodos como findByState, findByYear, etc.
}
