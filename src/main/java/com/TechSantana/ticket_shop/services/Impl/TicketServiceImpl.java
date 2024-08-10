package com.TechSantana.ticket_shop.services.Impl;

import com.TechSantana.ticket_shop.dtos.BuyTicketDto;
import com.TechSantana.ticket_shop.models.Ticket;
import com.TechSantana.ticket_shop.repositories.TicketRepository;
import com.TechSantana.ticket_shop.services.interfaces.TicketService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired private TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(BuyTicketDto dto) {
        Ticket ticket = new Ticket(
                dto.owner(), dto.show(), dto.price(), dto.date(), dto.meia()
        );
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> listTickets() {
        return ticketRepository.findAllByActiveTrue();
    }

    @Override
    public List<Ticket> getTicketsById(UUID id) {
        return ticketRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public Ticket editTicket(UUID id, BuyTicketDto dto) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if(ticket.isEmpty()){
            throw new EntityNotFoundException("Ticket not found");
        }

        Ticket newTicket = converteDtoParaEntidade(ticket.get(), dto);

        return ticketRepository.save(newTicket);
    }

    @Override
    public void deleteTicker(UUID id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if(ticket.isEmpty()){
            throw new EntityNotFoundException("Ticket Not found");
        }
        ticket.get().setActive(false);

        ticketRepository.save(ticket.get());
    }

    private Ticket converteDtoParaEntidade(Ticket ticket, BuyTicketDto dto){
        Optional.ofNullable(dto.owner()).ifPresent(ticket::setOwner);
        Optional.ofNullable(dto.show()).ifPresent(ticket::setShow);
        Optional.ofNullable(dto.price()).ifPresent(ticket::setPrice);
        Optional.ofNullable(dto.date()).ifPresent(ticket::setDate);
        Optional.ofNullable(dto.meia()).ifPresent(ticket::setMeia);

        return ticket;
    }
}
