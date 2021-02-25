package com.demo.mappers;

import com.demo.entity.Segment;
import com.demo.entity.Trip;
import com.demo.service.DateService;
import com.demo.service.SegmentServiceDto;
import com.demo.service.TripServiceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {TripMapperImpl.class})
@ContextConfiguration(classes = {SegmentMapperImpl.class, DateService.class})
class TripMapperTest {

    @Autowired
    private TripMapper uut;

    @Test
    void fromEntityToServiceDtoTest() {
        Segment segment = createSegment();
        List<Segment>  segments = List.of(segment);
        Trip trip = createTrip(segments);
        SegmentServiceDto segmentDto = createSegmentServiceDto();
        List<SegmentServiceDto>  segmentsDto = List.of(segmentDto);
        TripServiceDto expected = createTripServiceDto(segmentsDto);
        expected.setDateFromService("2020-12-26 00-00-00");
        TripServiceDto dto = uut.fromEntityToServiceDto(trip);
        assertEquals(expected, dto);
    }

    @Test
    void fromServiceDtoToEntityTest() {
        SegmentServiceDto segmentDto = createSegmentServiceDto();
        List<SegmentServiceDto>  segmentsDto = List.of(segmentDto);
        TripServiceDto tripDto = createTripServiceDto(segmentsDto);
        Segment segment = createSegment();
        List<Segment> segments = List.of(segment);
        Trip expected = createTrip(segments);
        expected.setDateFrom(LocalDateTime.of(2020, 12, 19, 0, 0, 0));
        Trip trip = uut.fromServiceDtoToEntity(tripDto);
        assertEquals(expected, trip);
    }

    private Segment createSegment() {
        return Segment.builder()
                .number(12345)
                .dateFrom(LocalDateTime.of(2020, 12, 24, 0, 0, 0))
                .dateTo(LocalDateTime.of(2020, 12, 24, 0, 0, 0))
                .airportFrom("OVB")
                .airportTo("DME")
                .build();
    }

    private SegmentServiceDto createSegmentServiceDto() {
        return SegmentServiceDto.builder()
                .numberService(12345)
                .dateFromService(new org.joda.time.LocalDateTime(2020, 12, 24, 0, 0, 0, 0))
                .dateToService(new org.joda.time.LocalDateTime(2020, 12, 24, 0, 0, 0, 0))
                .airportFromService("OVB")
                .airportToService("DME")
                .build();
    }

    private Trip createTrip(List<Segment> segments) {
        return Trip.builder()
                .dateFrom(LocalDateTime.of(2020, 12, 24, 0, 0, 0))
                .dateTo(LocalDateTime.of(2020, 12, 24, 0, 0, 0))
                .airportFrom("OVB")
                .airportTo("DME")
                .segments(segments)
                .build();
    }

    private TripServiceDto createTripServiceDto(List<SegmentServiceDto> segmentDtos) {
        return TripServiceDto.builder()
                .dateFromService("2020-12-24 00-00-00")
                .dateToService("2020-12-24 00-00-00")
                .airportFromService("OVB")
                .airportToService("DME")
                .segmentsService(segmentDtos)
                .build();
    }
}