package com.example.incidents_api.DTOs;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StateAgg {
    private String state;
    private Long incidents;
    private Long killed;
    private Long injured;
}
