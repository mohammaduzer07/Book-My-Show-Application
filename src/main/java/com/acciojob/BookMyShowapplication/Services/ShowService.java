package com.acciojob.BookMyShowapplication.Services;

import com.acciojob.BookMyShowapplication.CustomException.InvalidMovieException;
import com.acciojob.BookMyShowapplication.CustomException.InvalidTheaterException;
import com.acciojob.BookMyShowapplication.Entities.*;
import com.acciojob.BookMyShowapplication.Enums.SeatType;
import com.acciojob.BookMyShowapplication.Repository.MovieRepository;
import com.acciojob.BookMyShowapplication.Repository.ShowRepository;
import com.acciojob.BookMyShowapplication.Repository.ShowSeatRepository;
import com.acciojob.BookMyShowapplication.Repository.TheaterRepository;
import com.acciojob.BookMyShowapplication.Requests.AddShowRequest;
import com.acciojob.BookMyShowapplication.Requests.AddShowSeatsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private MovieRepository movieRepository;

    public String addShow(AddShowRequest showRequest) throws Exception{

        Movie movie = movieRepository.findMovieByMovieName(showRequest.getMovieName());

        if(movie == null){
            throw new InvalidMovieException("Movie Name entered does not exist in the DB");
        }

        Optional<Theater> theaterOptional = theaterRepository.findById(showRequest.getTheaterId());
        if(theaterOptional.isEmpty()){
            throw new InvalidTheaterException("Theater Id entered is incorrect");
        }
        Theater theater = theaterOptional.get();
        Show showEntity = new Show(showRequest.getShowDate(), showRequest.getShowTime());

        showEntity.setMovie(movie);
        showEntity.setTheater(theater);

        // Bidirectinal in the parent class

        movie.getShowList().add(showEntity);
        theater.getShowList().add(showEntity);

        showEntity = showRepository.save(showEntity);

        return "The show has been created with the showId "+showEntity.getShowId();
    }

    public String addShowSeats(AddShowSeatsRequest showSeatsRequest){

        Show show = showRepository.findById(showSeatsRequest.getShowId()).get();
        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();


        List<ShowSeat> showSeatList = new ArrayList<>();
        for(TheaterSeat theaterSeat : theaterSeatList){
            String seatNo = theaterSeat.getSeatNo();
            SeatType seatType = theaterSeat.getSeatType();

            ShowSeat showSeat = ShowSeat.builder()
                    .foodAttached(false)
                    .isAvailable(true)
                    .show(show)
                    .seatNo(seatNo)
                    .seatType(seatType).build();

            if(seatType.equals(SeatType.CLASSIC)){
                showSeat.setPrice(showSeatsRequest.getPriceForClassicSeats());
            }else{
                showSeat.setPrice(showSeatsRequest.getPriceForPremiumSeats());
            }
            showSeatList.add(showSeat);
        }

//        show.setShowSeatList(showSeatList);

        showSeatRepository.saveAll(showSeatList);

        return "Show seats have been added to the system";
    }
}
