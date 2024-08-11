package com.TechSantana.ticket_shop.repositories.interfaces;

import com.TechSantana.ticket_shop.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    List<Ticket> findAllByActiveTrue();
}
