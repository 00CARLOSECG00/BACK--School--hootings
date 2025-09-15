package com.example.incidents_api.DTOs;
import lombok.Data;

@Data
public class SchoolIncidentData {
  public String uid;
  public String nces_school_id;
  public String school_name;
  public String nces_district_id;
  public String district_name;
  public String date;
  public String school_year;
  public Integer year;
  public String time;
  public String day_of_week;
  public String city;
  public String state;
  public String school_type;
  public Integer enrollment;
  public Integer killed;
  public Integer injured;
  public Integer casualties;
  public Double staffing;


  public String shooting_type;
  public Integer age_shooter1;
  public String gender_shooter1;
  public String race_ethnicity_shooter1;
  public String shooter_relationship1;
  public Boolean shooter_deceased1;
  public String deceased_notes1;
  public Integer age_shooter2;
  public String gender_shooter2;
  public String race_ethnicity_shooter2;
  public String shooter_relationship2;
  public Boolean shooter_deceased2;
  public String deceased_notes2;
  public Integer white;
  public Integer black;
  public Integer hispanic;
  public Integer asian;
  public Integer american_indian_alaska_native;
  public Integer hawaiian_native_pacific_islander;
  public Integer two_or_more;
  public Boolean resource_officer;
  public String weapon;
  public String weapon_source;
  public Double lat;
  public Double long_;        
  public String low_grade;
  public String high_grade;
  public String lunch;
  public String county;
  public String state_fips;
  public String county_fips;
  public String ulocale;
}
