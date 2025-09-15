package com.example.incidents_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "incidents")
@Data
public class Incident {
    @Id
    private String uid;
    private String schoolName;
    private String state;
    private String city;
    private String date;
    private Integer killed;
    private Integer injured;
    private Integer casualties;
    private Double lat;
    private Double lon;
}
