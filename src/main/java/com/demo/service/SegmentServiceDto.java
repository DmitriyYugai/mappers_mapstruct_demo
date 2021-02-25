package com.demo.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class SegmentServiceDto {
    private int numberService;
    private LocalDateTime dateFromService;
    private LocalDateTime dateToService;
    private String airportFromService;
    private String airportToService;
}
