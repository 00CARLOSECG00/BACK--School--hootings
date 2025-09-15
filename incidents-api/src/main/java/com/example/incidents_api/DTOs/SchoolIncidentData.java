package com.example.incidents_api.DTOs;

import lombok.Data;

@Data
public class SchoolIncidentData {
    private String uid;
    private String nces_school_id;
    private String school_name;
    private String nces_district_id;
    private String district_name;
    private String date;
    private String school_year;
    private Integer year;
    private String time;
    private String day_of_week;
    private String city;
    private String state;
    private String school_type;
    private Integer enrollment;
    private Integer killed;
    private Integer injured;
    private Integer casualties;
    private String shooting_type;
    private Integer age_shooter1;
    private String gender_shooter1;
    private String race_ethnicity_shooter1;
    private String shooter_relationship1;
    private Boolean shooter_deceased1;
    private String deceased_notes1;
    private Integer age_shooter2;
    private String gender_shooter2;
    private String race_ethnicity_shooter2;
    private String shooter_relationship2;
    private Boolean shooter_deceased2;
    private String deceased_notes2;
    private Integer white;
    private Integer black;
    private Integer hispanic;
    private Integer asian;
    private Integer american_indian_alaska_native;
    private Integer hawaiian_native_pacific_islander;
    private Integer two_or_more;
    private Boolean resource_officer;
    private String weapon;
    private String weapon_source;
    private Double lat;
    private Double lon;
    private Integer staffing;
    private String low_grade;
    private String high_grade;
    private String lunch;
    private String county;
    private String state_fips;
    private String county_fips;
    private String ulocale;
}
