package com.acciojob.BookMyShowapplication.Services;

import com.acciojob.BookMyShowapplication.Entities.Theater;
import com.acciojob.BookMyShowapplication.Entities.TheaterSeat;
import com.acciojob.BookMyShowapplication.Enums.SeatType;
import com.acciojob.BookMyShowapplication.Repository.TheaterRepository;
import com.acciojob.BookMyShowapplication.Requests.AddTheaterRequest;
import com.acciojob.BookMyShowapplication.Requests.AddTheaterSeatsRequest;
import com.acciojob.BookMyShowapplication.Transformers.TheaterTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;
    public String addTheater(AddTheaterRequest theaterRequest){
        Theater theater = TheaterTransformers.convertRequestToEntity(theaterRequest);
        theater = theaterRepository.save(theater);

        return "Theater has been saved to DB with theaterId "+theater.getTheaterId();
    }

    public String addTheaterSeats(AddTheaterSeatsRequest theaterSeatsRequest){

        int noOfClassicSeats = theaterSeatsRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = theaterSeatsRequest.getNoOfPremiumSeats();
        //TODO make sure the theater seats are unique so that you dont need to store the seatType
        List<TheaterSeat> theaterSeatList = new ArrayList<>();
        Theater theater = theaterRepository.findById(theaterSeatsRequest.getTheaterId()).get();
        int count = 0;
        int nextRowNo = 1;
        char ch = 'A';

        for(int i = 1; i <= noOfClassicSeats; i++){
            String seatNo = Integer.toString(nextRowNo) + ch;

            ch++;
            count++;
            if(count == 5){
                count = 0;
                nextRowNo++;
                ch = 'A';
            }

            TheaterSeat theaterSeatEntity = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeatEntity);
        }

        for(int i = 1; i <= noOfPremiumSeats; i++){
            String seatNo = Integer.toString(nextRowNo) + ch;

            ch++;
            count++;
            if(count == 5){
                count = 0;
                nextRowNo++;
                ch = 'A';
            }

            TheaterSeat theaterSeatEntity = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeatEntity);
        }
        //Created a TheaterSeat Entity : set the FK in the Theater Seat Entity
        //Setting the variable of the Bidirectional mapping in the parent class
        theater.setTheaterSeatList(theaterSeatList);

        //Save both parent and child : Not required , only save the parent :
        theaterRepository.save(theater);

        return "Theater seats have been added";
        // Every row need to have atMax 5 seats

        //Generate the TheaterSeats Entities

        //Save the relevant attribute
    }
}

