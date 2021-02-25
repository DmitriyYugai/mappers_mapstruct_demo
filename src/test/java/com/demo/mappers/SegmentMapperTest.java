package com.demo.mappers;

import com.demo.entity.Segment;
import com.demo.service.SegmentServiceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {SegmentMapperImpl.class})
class SegmentMapperTest {

    @Autowired
    private SegmentMapper uut;

    @Test
    void fromEntityToServiceDtoTest() {
        Segment segment = createSegment();
        SegmentServiceDto expected = createSegmentServiceDto();
        SegmentServiceDto dto = uut.fromEntityToServiceDto(segment);
        assertEquals(expected, dto);
    }

    @Test
    void fromServiceDtoToEntityTest() {
        SegmentServiceDto segmentService = new SegmentServiceDto(
                12345,
                new org.joda.time.LocalDateTime(2020, 12, 24, 0, 0, 0, 0),
                new org.joda.time.LocalDateTime(2020, 12, 24, 0, 0, 0, 0),
                "OVB",
                "DME"
        );
        Segment expected = new Segment(
                12345,
                LocalDateTime.of(2020, 12, 24, 0, 0, 0),
                LocalDateTime.of(2020, 12, 24, 0, 0, 0),
                "OVB",
                "DME"
        );
        Segment entity = uut.fromServiceDtoToEntity(segmentService);
        assertEquals(expected, entity);
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

}