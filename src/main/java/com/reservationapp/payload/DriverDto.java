package com.reservationapp.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    private Long id;
    private String name;
    private String licenseNumber;
    private String aadharNumber;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailId;
}
