package com.reservationapp.controller;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.RouteDto;
import com.reservationapp.payload.SubRouteDto;
import com.reservationapp.repository.SubRouteRepository;
import com.reservationapp.service.SubRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/subroute")
public class SubRouteController {
    @Autowired
    private SubRouteService subRouteService;
    //http://localhost:8080/api/subroute/busId
    @PostMapping("/{busId}/{routId}")
    public ResponseEntity<SubRouteDto> addSubRoute(@PathVariable long busId,long routeId, @RequestBody SubRouteDto subRouteDto){

        SubRouteDto dto = subRouteService.addSubRoute(subRouteDto, busId,routeId);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);


    }



}
