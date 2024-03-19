package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Driver;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.SubRouteDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.DeriverRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    SubRouteRepository subRouteRepository;
    @Autowired
    private DeriverRepository driverRepository;
    @Transactional
    //It ensures that the addBus method executes as a single transaction. If any exception occurs during the execution of this method
    //All changes made within method will be rolled back.
    public Bus addBus(BusDto busDto) {
        //Create Bus Entity

        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());


        Bus savedBus = busRepository.save(bus);

        return savedBus;
    }
}







