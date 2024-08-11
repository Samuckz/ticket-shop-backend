package com.TechSantana.ticket_shop.services.interfaces;

import com.TechSantana.ticket_shop.dtos.events.CreateEventDto;
import com.TechSantana.ticket_shop.models.Event;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventService {
    ResponseEntity createEvent(CreateEventDto dto);

    Event getEvent(UUID uuid);

    List<Event> getAllEvents();

}
