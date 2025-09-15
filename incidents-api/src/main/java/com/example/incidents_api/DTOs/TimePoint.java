package com.example.incidents_api.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimePoint {
    private String period;
    private Long incidents;
    private Long killed;
    private Long injured;
}
