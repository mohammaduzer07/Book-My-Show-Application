package com.acciojob.BookMyShowapplication.Entities;

import com.acciojob.BookMyShowapplication.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "show_seats")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;
    private int price;
    private boolean isAvailable;
    private  boolean foodAttached;
    private String seatNo; // These values will
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType; // come from the theater seats based on mapping or seat structure

    @JsonIgnore
    @JoinColumn
    @ManyToOne
    private Show show;


}
