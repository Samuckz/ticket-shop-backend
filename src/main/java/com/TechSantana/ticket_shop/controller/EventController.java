package com.TechSantana.ticket_shop.controller;

import com.TechSantana.ticket_shop.dtos.events.CreateEventDto;
import com.TechSantana.ticket_shop.models.Event;
import com.TechSantana.ticket_shop.services.interfaces.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;
    @GetMapping("/initialRequest")
    public ResponseEntity initialRequest(){
        return ResponseEntity.ok("Event Controller");
    }

    @PostMapping
    public ResponseEntity createEvent(@RequestBody CreateEventDto eventDto){
        return eventService.createEvent(eventDto);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents(){
        return ResponseEntity.ok().body(eventService.getAllEvents());
    }
}
