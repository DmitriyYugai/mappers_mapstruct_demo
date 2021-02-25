package com.demo.mappers;

import com.demo.entity.Segment;
import com.demo.service.SegmentServiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SegmentMapper {
    @Mappings({
            @Mapping(target="numberService", source="segment.number"),
            @Mapping(target="dateFromService", source="segment.dateFrom",
                    qualifiedByName="dateFromToDateFromService"),
            @Mapping(target="dateToService", source="segment.dateTo",
                    qualifiedByName="dateToToDateToService"),
            @Mapping(target="airportFromService", source="segment.airportFrom"),
            @Mapping(target="airportToService", source="segment.airportTo")})
    SegmentServiceDto fromEntityToServiceDto(Segment segment);

    @Named("dateFromToDateFromService")
    static org.joda.time.LocalDateTime dateFromToDateFromService(LocalDateTime dateFrom) {
        return new org.joda.time.LocalDateTime()
                .withDate(dateFrom.getYear(), dateFrom.getMonthValue(), dateFrom.getDayOfMonth())
                .withTime(dateFrom.getHour(), dateFrom.getMinute(), dateFrom.getSecond(), 0);
    }

    @Named("dateToToDateToService")
    static org.joda.time.LocalDateTime dateToToDateToService(LocalDateTime dateTo) {
        return new org.joda.time.LocalDateTime()
                .withDate(dateTo.getYear(), dateTo.getMonthValue(), dateTo.getDayOfMonth())
                .withTime(dateTo.getHour(), dateTo.getMinute(), dateTo.getSecond(), 0);
    }

    @Mappings({
            @Mapping(target="number", source="dto.numberService"),
            @Mapping(target="dateFrom", source="dto.dateFromService",
                    qualifiedByName="dateFromServiceToDateFrom"),
            @Mapping(target="dateTo", source="dto.dateToService",
                    qualifiedByName="dateToServiceToDateTo"),
            @Mapping(target="airportFrom", source="dto.airportFromService"),
            @Mapping(target="airportTo", source="dto.airportToService")})
    Segment fromServiceDtoToEntity(SegmentServiceDto dto);

    @Named("dateFromServiceToDateFrom")
    static LocalDateTime dateFromServiceToDateFrom(org.joda.time.LocalDateTime  dateFromService) {
        return LocalDateTime.of(
                dateFromService.getYear(), dateFromService.getMonthOfYear(), dateFromService.getDayOfMonth(),
                dateFromService.getHourOfDay(), dateFromService.getMinuteOfHour(), dateFromService.getSecondOfMinute());

    }

    @Named("dateToServiceToDateTo")
    static LocalDateTime dateToServiceToDateTo(org.joda.time.LocalDateTime dateToService) {
        return LocalDateTime.of(
                dateToService.getYear(), dateToService.getMonthOfYear(), dateToService.getDayOfMonth(),
                dateToService.getHourOfDay(), dateToService.getMinuteOfHour(), dateToService.getSecondOfMinute());
    }

    List<SegmentServiceDto> fromEntitiesToServiceDtos(List<Segment> entities);

    List<Segment> fromServiceDtosToEntities(List<SegmentServiceDto> serviceDtos);

}
