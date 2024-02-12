package com.acciojob.BookMyShowapplication.Controllers;

import com.acciojob.BookMyShowapplication.Entities.Show;
import com.acciojob.BookMyShowapplication.Entities.Ticket;
import com.acciojob.BookMyShowapplication.Repository.TicketRepository;
import com.acciojob.BookMyShowapplication.Requests.AddBookTicketRequest;
import com.acciojob.BookMyShowapplication.Response.ShowTicketResponse;
import com.acciojob.BookMyShowapplication.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @PostMapping("/bookTicket")
    public ResponseEntity bookTicket(@RequestBody AddBookTicketRequest bookTicketRequest){
        try{
            String result = ticketService.bookTicket(bookTicketRequest);
            return new ResponseEntity<>(result, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("viewTicket")
    public ShowTicketResponse viewTicket(@RequestParam("ticketId") Integer ticketId){

        ShowTicketResponse showTicketResponse = ticketService.viewTicket(ticketId);
        return showTicketResponse;
    }

}
