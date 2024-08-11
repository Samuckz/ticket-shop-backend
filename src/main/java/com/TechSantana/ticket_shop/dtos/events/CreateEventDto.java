package com.TechSantana.ticket_shop.dtos.events;

import com.TechSantana.ticket_shop.utils.enums.EventCategory;

import java.time.LocalDateTime;

public record CreateEventDto(
        String name,
        String description,
        EventCategory category,
        LocalDateTime startDate,
        LocalDateTime endingDate,
        String location,
        Long maxCapacity
) {
}
