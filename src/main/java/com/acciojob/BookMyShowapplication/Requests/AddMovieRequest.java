package com.acciojob.BookMyShowapplication.Requests;

import com.acciojob.BookMyShowapplication.Enums.Genre;
import com.acciojob.BookMyShowapplication.Enums.Language;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AddMovieRequest {

    private String movieName;
    private Genre genre;
    private Language movieLanguage;
    private LocalDate releaseDate;
    private double duration;
    private double rating;
}
