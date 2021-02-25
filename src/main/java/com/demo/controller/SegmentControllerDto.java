package com.demo.controller;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SegmentControllerDto {
    private int numberController;
    private String dateFromController;
    private String dateToController;
    private String airportFromController;
    private String airportToController;
}
