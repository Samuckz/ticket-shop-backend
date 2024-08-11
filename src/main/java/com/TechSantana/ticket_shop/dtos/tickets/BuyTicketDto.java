package com.TechSantana.ticket_shop.dtos.tickets;

import com.TechSantana.ticket_shop.models.Event;

import java.time.LocalDateTime;
import java.util.UUID;

public record BuyTicketDto(
         String owner,
         String event,
         Double price,
         Boolean meia
) {
}
