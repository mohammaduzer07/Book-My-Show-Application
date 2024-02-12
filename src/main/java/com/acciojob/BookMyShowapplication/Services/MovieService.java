package com.acciojob.BookMyShowapplication.Services;

import com.acciojob.BookMyShowapplication.Entities.Movie;
import com.acciojob.BookMyShowapplication.Repository.MovieRepository;
import com.acciojob.BookMyShowapplication.Requests.AddMovieRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(AddMovieRequest movieRequest){

        // old method : create an object using the constructor
        // "Builder annotation req AllArgsConstructor mandatory

        // new method : create obj using the Builder annotation
        Movie movie = Movie.builder()
                .movieName(movieRequest.getMovieName())
                .genre(movieRequest.getGenre())
                .movieLanguage(movieRequest.getMovieLanguage())
                .releaseDate(movieRequest.getReleaseDate())
                .duration(movieRequest.getDuration())
                .build(); // will simply build all the above obj
        movie = movieRepository.save(movie);

        return "The movie has been saved with the movieId "+movie.getMovieId();
    }
    public Movie getMovie(Integer mevieId){

        Movie movie = movieRepository.findById(mevieId).get();
        return movie;
    }
}
