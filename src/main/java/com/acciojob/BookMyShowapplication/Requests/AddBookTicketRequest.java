package com.acciojob.BookMyShowapplication.Requests;

import com.acciojob.BookMyShowapplication.Enums.SeatType;
import lombok.Data;

import java.util.List;
@Data
public class AddBookTicketRequest {
    private int showId;
    private List<String> seatList;
    private SeatType seatType;
    private String emailId; // we can take the userId
}
