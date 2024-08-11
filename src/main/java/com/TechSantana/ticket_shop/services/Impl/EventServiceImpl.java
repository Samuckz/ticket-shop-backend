package com.TechSantana.ticket_shop.services.Impl;

import com.TechSantana.ticket_shop.dtos.events.CreateEventDto;
import com.TechSantana.ticket_shop.models.Event;
import com.TechSantana.ticket_shop.repositories.interfaces.EventRepository;
import com.TechSantana.ticket_shop.services.interfaces.EventService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Override
    public ResponseEntity createEvent(CreateEventDto dto) {
        Event event = new Event();
        BeanUtils.copyProperties(dto, event);
        event.setAvaliableTickets(dto.maxCapacity());
        Event response = eventRepository.save(event);
        return new ResponseEntity(event, HttpStatus.CREATED);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // === GENERIC METHODS ===

    public Event getEvent(UUID id){
        Optional<Event> event = eventRepository.findById(id);
        if(event.isEmpty()){
            throw new EntityNotFoundException("Event not Found");
        }

        return event.get();
    }
}
