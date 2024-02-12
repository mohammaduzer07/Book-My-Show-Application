package com.acciojob.BookMyShowapplication.Transformers;

import com.acciojob.BookMyShowapplication.Entities.Theater;
import com.acciojob.BookMyShowapplication.Requests.AddTheaterRequest;

public class TheaterTransformers {

    public static Theater convertRequestToEntity(AddTheaterRequest theaterRequest){

        Theater theater = Theater.builder()
                .address(theaterRequest.getAddress())
                .noOfScreens(theaterRequest.getNoOfScreens())
                .name(theaterRequest.getName())
                .build();

        return theater;
    }
}
