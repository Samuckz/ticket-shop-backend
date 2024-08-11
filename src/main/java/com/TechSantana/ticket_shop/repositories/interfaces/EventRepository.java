package com.TechSantana.ticket_shop.repositories.interfaces;

import com.TechSantana.ticket_shop.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
