package com.acciojob.BookMyShowapplication.Controllers;

import com.acciojob.BookMyShowapplication.Entities.Movie;
import com.acciojob.BookMyShowapplication.Requests.AddMovieRequest;
import com.acciojob.BookMyShowapplication.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest addMovieRequest){

        String result = movieService.addMovie(addMovieRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getMovieInfo")
    public Movie getMovie(@RequestParam("movieId") Integer movieId){

        return movieService.getMovie(movieId);
    }
}
