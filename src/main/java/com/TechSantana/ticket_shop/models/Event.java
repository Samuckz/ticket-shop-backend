package com.TechSantana.ticket_shop.models;

import com.TechSantana.ticket_shop.utils.enums.EventCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_events")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "The event's name is mandatory!")
    private String name;

    @NotBlank(message = "The event's description is mandatory!")
    private String description;

    @NotNull(message = "The event's category is mandatory!")
    private EventCategory category;

    @NotNull(message = "The event's start date is mandatory!")
    private LocalDateTime startDate;

    @NotNull(message = "The event's ending date is mandatory!")
    private LocalDateTime endingDate;

    @NotBlank(message = "The event's location is mandatory!")
    private String location;

    @NotNull(message = "The event's max capacity date is mandatory!")
    private Long maxCapacity;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<Ticket> tickets = new HashSet<>();

    private Long avaliableTickets;

}
