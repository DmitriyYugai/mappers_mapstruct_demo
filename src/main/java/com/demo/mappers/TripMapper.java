package com.demo.mappers;

import com.demo.entity.Trip;
import com.demo.service.DateService;
import com.demo.service.TripServiceDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = SegmentMapper.class, unmappedTargetPolicy = ReportingPolicy.ERROR)
public abstract class TripMapper {

    @Autowired
    protected DateService dateService;

    @Mappings({
            @Mapping(target="dateFromService", source="trip.dateFrom",
                    dateFormat="yyyy-MM-dd HH-mm-ss"),
            @Mapping(target="dateToService", source="trip.dateTo",
                    dateFormat="yyyy-MM-dd HH-mm-ss"),
            @Mapping(target="airportFromService", source="trip.airportFrom"),
            @Mapping(target="airportToService", source="trip.airportTo"),
            @Mapping(target="segmentsService", source = "trip.segments")})
    public abstract TripServiceDto fromEntityToServiceDto(Trip trip);

    @BeforeMapping
    protected void addDays(Trip trip, @MappingTarget TripServiceDto tripDto) {
        trip.setDateFrom(dateService.addDays(trip.getDateFrom(), 2));
    }

    @Mappings({
            @Mapping(target="dateFrom", source="tripDto.dateFromService",
                    dateFormat="yyyy-MM-dd HH-mm-ss"),
            @Mapping(target="dateTo", source="tripDto.dateToService",
                    dateFormat="yyyy-MM-dd HH-mm-ss"),
            @Mapping(target="airportFrom", source="tripDto.airportFromService"),
            @Mapping(target="airportTo", source="tripDto.airportToService"),
            @Mapping(target="segments", source = "tripDto.segmentsService")})
    public abstract Trip fromServiceDtoToEntity(TripServiceDto tripDto);

    @AfterMapping
    protected void subtractDays(@MappingTarget Trip trip, TripServiceDto tripDto) {
        trip.setDateFrom(dateService.subtractDays(trip.getDateFrom(), 5));
    }

}
