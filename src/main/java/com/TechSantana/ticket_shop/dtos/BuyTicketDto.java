package com.TechSantana.ticket_shop.dtos;

import java.time.LocalDateTime;

public record BuyTicketDto(
         String owner,
         String show,
         Double price,
         LocalDateTime date,
         Boolean meia
) {
}
