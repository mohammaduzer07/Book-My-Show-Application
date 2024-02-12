package com.acciojob.BookMyShowapplication.Controllers;

import com.acciojob.BookMyShowapplication.Requests.AddShowRequest;
import com.acciojob.BookMyShowapplication.Requests.AddShowSeatsRequest;
import com.acciojob.BookMyShowapplication.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    private ShowService showService;
    @PostMapping("/addShow")
    public ResponseEntity addShow(@RequestBody AddShowRequest showRequest){

        try{
            String result = showService.addShow(showRequest);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addShowSeats")
    public ResponseEntity addShowSeats(@RequestBody AddShowSeatsRequest showSeatsRequest){

        try{
            String result = showService.addShowSeats(showSeatsRequest);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
