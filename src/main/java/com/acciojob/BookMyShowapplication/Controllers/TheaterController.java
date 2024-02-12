package com.acciojob.BookMyShowapplication.Controllers;

import com.acciojob.BookMyShowapplication.Requests.AddTheaterRequest;
import com.acciojob.BookMyShowapplication.Requests.AddTheaterSeatsRequest;
import com.acciojob.BookMyShowapplication.Response.ShowTicketResponse;
import com.acciojob.BookMyShowapplication.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;
    @PostMapping("/addTheater")
    public String addTheater(@RequestBody AddTheaterRequest addTheaterRequest){
        String result = theaterService.addTheater(addTheaterRequest);

        return result;
    }

    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats(@RequestBody AddTheaterSeatsRequest theaterSeatsRequest){

        String result = theaterService.addTheaterSeats(theaterSeatsRequest);
        return result;
    }


}
