package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.exception.ResourceNotFound;
import com.reservationapp.payload.RouteDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusRepository busRepository;

    public Route createRoute(long busId, RouteDto routeDto) {
        Bus bus = busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFound("Bus not added!!")
        );

        Route routeStatus = routeRepository.findByBusId(routeDto.getBusId());
        if(routeStatus!=null){
            throw new RuntimeException("Route was already added!!");
        }
        if (routeStatus == null) {
            Route route=new Route();
            route.setFromLocation(routeDto.getFromLocation());
            route.setToLocation(routeDto.getToLocation());
            route.setFromDate(routeDto.getToDate());
            route.setToDate(routeDto.getToDate());
            route.setTotalDuration(routeDto.getTotalDuration());
            route.setFromTime(routeDto.getFromTime());
            route.setToTime(routeDto.getToTime());
            route.setBusId(routeDto.getBusId());

            routeRepository.save(route);
            return route;
        }
        return null;
    }}
