package com.acciojob.BookMyShowapplication.Repository;

import com.acciojob.BookMyShowapplication.Entities.Movie;
import com.acciojob.BookMyShowapplication.Enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    //1 type of fetch where we just need to define inBuilt function

    //2nd type of fetch where we just define the method
    //no query nothing
    // but naming of the method has to be same as attributeName has to be strict

    Movie findMovieByMovieNameAndMovieLanguage(String movieName, Language language);

    Movie findMovieByMovieName(String movieName);
    List<Movie> findAllByDurationGreaterThanEqual(double duration);

}
