package com.demo.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class DateService {
    public LocalDateTime addDays(LocalDateTime date, int days) {
        return date.plusDays(days);
    }

    public LocalDateTime subtractDays(LocalDateTime date, int days) {
        return date.minusDays(days);
    }
}
