package com.example.incidents_api.DTOs;

import lombok.Data;
import java.util.List;

@Data
public class LookupData {
    private List<String> states;
    private List<String> schoolTypes;
    private List<String> shootingTypes;
    private List<Integer> years;
}
