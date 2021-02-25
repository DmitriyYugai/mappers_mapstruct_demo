package com.demo.controller;

import com.demo.entity.Segment;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TripControllerDto {
    private LocalDateTime dateFromController;
    private LocalDateTime dateToController;
    private String airportFromController;
    private String airportToController;
    private List<Segment> segmentsController;
}
