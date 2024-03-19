package com.reservationapp.service;

import com.reservationapp.controller.SubRouteController;
import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.exception.ResourceNotFound;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.SubRouteDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubRouteService {
    @Autowired
    private SubRouteRepository subRouteRepository;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;

    public SubRouteDto addSubRoute( SubRouteDto subRouteDto, Long busId,Long routeId){
        Bus bus = busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFound("Bus not added!!")
        );
        Route route1 = routeRepository.findById(routeId).orElseThrow(
                () -> new ResourceNotFound("Route not added!!")
        );

        SubRoute subRouteStatus = subRouteRepository.findByBusId(subRouteDto.getBusId());
        if(subRouteStatus!=null){
            throw new RuntimeException("SubRoute was already added!!");
        }
        if (subRouteStatus == null) {
            SubRoute subRoute = mapToEntity(subRouteDto);
            SubRoute savedSubRoute = subRouteRepository.save(subRoute);
            SubRouteDto dto = mapToDto(subRoute);

            return dto;
        }
        return null;
    }

    private SubRoute mapToEntity(SubRouteDto subRouteDto) {
        SubRoute subRoute = new SubRoute();
        subRoute.setFromLocation(subRouteDto.getFromLocation());
        subRoute.setToLocation(subRouteDto.getToLocation());
        subRoute.setFromDate(subRouteDto.getFromDate());
        subRoute.setToDate(subRoute.getToDate());
        subRoute.setFromTime(subRoute.getToTime());
        subRoute.setToTime(subRoute.getToTime());
        subRoute.setTotalDuration(subRouteDto.getTotalDuration());
        subRoute.setBusId(subRouteDto.getBusId());
        subRoute.setRouteId(subRouteDto.getRouteId());
        return subRoute;
    }
    private SubRouteDto mapToDto(SubRoute subRoute) {
        SubRouteDto subRouteDto = new SubRouteDto();
        subRouteDto.setId(subRoute.getId());
        subRouteDto.setFromLocation(subRoute.getFromLocation());
        subRouteDto.setToLocation(subRoute.getToLocation());
        subRouteDto.setFromDate(subRoute.getFromDate());
        subRouteDto.setToDate(subRoute.getToDate());
        subRouteDto.setFromTime(subRoute.getFromTime());
        subRouteDto.setToTime(subRoute.getToTime());
        subRouteDto.setTotalDuration(subRoute.getTotalDuration());
        subRouteDto.setBusId(subRoute.getBusId());
        subRouteDto.setRouteId(subRoute.getRouteId());
        return subRouteDto;
    }

}
