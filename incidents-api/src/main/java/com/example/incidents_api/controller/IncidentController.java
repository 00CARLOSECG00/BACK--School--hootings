package com.example.incidents_api.controller;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.example.incidents_api.DTOs.SchoolIncidentData;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IncidentController {
  private final JdbcTemplate jdbc;

  public IncidentController(JdbcTemplate jdbc) { this.jdbc = jdbc; }

 @GetMapping("/incidents")
public List<SchoolIncidentData> list(
    @RequestParam(required = false) String from,
    @RequestParam(required = false) String to,
    @RequestParam(required = false) String state,                  // "CO" o "CO,CA,TX"
    @RequestParam(required = false, name = "school_type") String schoolType // "High School" o "High School,Middle School"
) {
  StringBuilder sql = new StringBuilder("""
    SELECT uid,nces_school_id,school_name,nces_district_id,district_name,
           "date",school_year,year,time,day_of_week,city,state,school_type,
           enrollment,killed,injured,casualties,shooting_type,
           age_shooter1,gender_shooter1,race_ethnicity_shooter1,shooter_relationship1,shooter_deceased1,deceased_notes1,
           age_shooter2,gender_shooter2,race_ethnicity_shooter2,shooter_relationship2,shooter_deceased2,deceased_notes2,
           white,black,hispanic,asian,american_indian_alaska_native,hawaiian_native_pacific_islander,two_or_more,
           resource_officer,weapon,weapon_source,lat,"long" AS long_,
           staffing,low_grade,high_grade,lunch,county,state_fips,county_fips,ulocale
    FROM vw_incidents
    WHERE 1=1
  """);

  List<Object> params = new java.util.ArrayList<>();

  if (from != null && !from.isBlank()) {
    sql.append(" AND to_date(\"date\", 'MM/DD/YYYY') >= to_date(?, 'YYYY-MM-DD') ");
    params.add(from);
  }
  if (to != null && !to.isBlank()) {
    sql.append(" AND to_date(\"date\", 'MM/DD/YYYY') <= to_date(?, 'YYYY-MM-DD') ");
    params.add(to);
  }
  if (state != null && !state.isBlank()) {
    sql.append(" AND state = ANY (string_to_array(?, ',')) ");
    params.add(state);
  }
  if (schoolType != null && !schoolType.isBlank()) {
    sql.append(" AND school_type = ANY (string_to_array(?, ',')) ");
    params.add(schoolType);
  }

  sql.append(" ORDER BY year NULLS LAST, to_date(\"date\", 'MM/DD/YYYY') NULLS LAST, uid ");

  return jdbc.query(sql.toString(), params.toArray(), new org.springframework.jdbc.core.BeanPropertyRowMapper<>(SchoolIncidentData.class));
}


  @GetMapping("/incidents/{uid}")
  public SchoolIncidentData byId(@PathVariable String uid){
    String sql = """
      SELECT uid,nces_school_id,school_name,nces_district_id,district_name,
             date,school_year,year,time,day_of_week,city,state,school_type,
             enrollment,killed,injured,casualties,shooting_type,
             age_shooter1,gender_shooter1,race_ethnicity_shooter1,shooter_relationship1,shooter_deceased1,deceased_notes1,
             age_shooter2,gender_shooter2,race_ethnicity_shooter2,shooter_relationship2,shooter_deceased2,deceased_notes2,
             white,black,hispanic,asian,american_indian_alaska_native,hawaiian_native_pacific_islander,two_or_more,
             resource_officer,weapon,weapon_source,lat,long AS long_,
             NULLIF(staffing::text,'')::int AS staffing,low_grade,high_grade,lunch,county,state_fips,county_fips,ulocale
      FROM vw_incidents WHERE uid = ?
    """;
    return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(SchoolIncidentData.class), uid);
  }

  @GetMapping("/lookups")
  public java.util.Map<String,Object> lookups(){
    var states = jdbc.queryForList("SELECT DISTINCT state FROM vw_incidents WHERE state <> '' ORDER BY 1", String.class);
    var schoolTypes = jdbc.queryForList("SELECT DISTINCT school_type FROM vw_incidents WHERE school_type <> '' ORDER BY 1", String.class);
    var shootingTypes = jdbc.queryForList("SELECT DISTINCT shooting_type FROM vw_incidents WHERE shooting_type <> '' ORDER BY 1", String.class);
    var years = jdbc.queryForList("SELECT DISTINCT year FROM vw_incidents WHERE year IS NOT NULL ORDER BY 1", Integer.class);
    return java.util.Map.of("states", states, "school_types", schoolTypes, "shooting_types", shootingTypes, "years", years, "districts", java.util.List.of());
  }
}
