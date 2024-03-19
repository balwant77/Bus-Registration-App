package com.reservationapp.payload;

import lombok.Data;

@Data
public class SearchListOfBusesDto {
    private long busId;
    private String busNumber;
    private String busType;

    private String price;
    private int totalSeats;
    private int availableSeats;

    private Long routId;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
}
