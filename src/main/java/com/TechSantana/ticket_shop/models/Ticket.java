package com.TechSantana.ticket_shop.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_tickets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String owner;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private Double price;

    private Boolean meia;

    private Boolean active;

    public Ticket(String owner, Event event, Double price, Boolean meia) {
        this.owner = owner;
        this.event = event;
        this.price = price;
        this.meia = meia;
        this.active = true;
    }
}
