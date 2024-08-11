package com.TechSantana.ticket_shop.controller;

import com.TechSantana.ticket_shop.dtos.tickets.BuyTicketDto;
import com.TechSantana.ticket_shop.models.Ticket;
import com.TechSantana.ticket_shop.services.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired private TicketService ticketService;

    @PostMapping
    private ResponseEntity<Ticket> createTicket(@RequestBody BuyTicketDto buyTicketDto){
        Ticket response = ticketService.createTicket(buyTicketDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping
    private ResponseEntity<List<Ticket>> listTickets(){
        return new ResponseEntity<>(ticketService.listTickets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<List<Ticket>> listTickestByUser(@PathVariable UUID id){
        List<Ticket> response = ticketService.getTicketsById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Ticket> editarTicket(@PathVariable UUID id, @RequestBody BuyTicketDto dto){
        return new ResponseEntity<>(ticketService.editTicket(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    private ResponseEntity deleteTicket(@PathVariable UUID id){
        ticketService.deleteTicker(id);
        return new ResponseEntity<>("Ticket Deleted Successfully!", HttpStatus.OK);
    }
}
