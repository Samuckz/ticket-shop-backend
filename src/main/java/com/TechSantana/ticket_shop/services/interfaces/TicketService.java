package com.TechSantana.ticket_shop.services.interfaces;

import com.TechSantana.ticket_shop.dtos.tickets.BuyTicketDto;
import com.TechSantana.ticket_shop.models.Ticket;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    Ticket createTicket(BuyTicketDto dto);

    List<Ticket> listTickets();

    List<Ticket> getTicketsById(UUID id);

    Ticket editTicket(UUID id, BuyTicketDto dto);

    void deleteTicker(UUID id);
}
