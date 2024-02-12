package com.acciojob.BookMyShowapplication.Requests;

import com.acciojob.BookMyShowapplication.Entities.Movie;
import com.acciojob.BookMyShowapplication.Entities.Theater;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class AddShowRequest {
    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;//from this we will figureOut MovieEntity
    private int theaterId;
}
