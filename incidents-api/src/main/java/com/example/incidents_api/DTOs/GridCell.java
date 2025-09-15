package com.example.incidents_api.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GridCell {
    private String geohash6;
    private Long incidents;
}
