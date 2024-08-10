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

    private String show;

    private Double price;

    private LocalDateTime date;

    private Boolean meia;

    private Boolean active;

    public Ticket(String owner, String show, Double price, LocalDateTime date, Boolean meia) {
        this.owner = owner;
        this.show = show;
        this.price = price;
        this.date = date;
        this.meia = meia;
        this.active = true;
    }
}
