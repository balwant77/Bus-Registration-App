package com.reservationapp.payload;

import com.reservationapp.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusDto {
    private Long busId;
    private String busNumber;
    private String busType;
    private String price;
    private int totalSeats;
    private int availableSeats;

}
