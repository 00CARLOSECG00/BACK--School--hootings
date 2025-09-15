package com.example.incidents_api.DTOs;

import lombok.Data;

@Data
public class Shooter {
    private String id;
    private String incident_uid;
    private Integer order;
    private Integer age;
    private String gender;
    private String race_ethnicity;
    private String relationship_to_school;
    private Boolean deceased;
    private String deceased_notes;
}
