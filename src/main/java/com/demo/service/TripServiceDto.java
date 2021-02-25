package com.demo.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class TripServiceDto {
    private String dateFromService;
    private String dateToService;
    private String airportFromService;
    private String airportToService;
    private List<SegmentServiceDto> segmentsService;
}
