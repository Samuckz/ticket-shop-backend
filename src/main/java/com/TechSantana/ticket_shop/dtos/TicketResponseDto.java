package com.TechSantana.ticket_shop.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketResponseDto(
        UUID id,
        String owner,
        String show,
        Double price,
        LocalDateTime date,
        boolean meia
) {
}
