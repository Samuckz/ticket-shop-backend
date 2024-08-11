package com.TechSantana.ticket_shop.services.Impl;

import com.TechSantana.ticket_shop.dtos.tickets.BuyTicketDto;
import com.TechSantana.ticket_shop.models.Event;
import com.TechSantana.ticket_shop.models.Ticket;
import com.TechSantana.ticket_shop.repositories.interfaces.TicketRepository;
import com.TechSantana.ticket_shop.services.interfaces.EventService;
import com.TechSantana.ticket_shop.services.interfaces.TicketService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {
    @Autowired private TicketRepository ticketRepository;

    @Autowired private EventService eventService;

    @Override
    @Transactional
    public Ticket createTicket(BuyTicketDto dto) {
        log.info("Creating ticket");

        try{
            Event event = eventService.getEvent(UUID.fromString(dto.event()));

            Ticket ticket = new Ticket(
                    dto.owner(), event, dto.price(), dto.meia()
            );

            event.getTickets().add(ticket);
            event.setAvaliableTickets(event.getAvaliableTickets() - 1);
            return ticketRepository.save(ticket);
        } catch (Exception e){
            throw e;
        }
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
        Optional.ofNullable(dto.price()).ifPresent(ticket::setPrice);
        Optional.ofNullable(dto.meia()).ifPresent(ticket::setMeia);

        return ticket;
    }
}
