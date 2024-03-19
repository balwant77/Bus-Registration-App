package com.reservationapp.controller;

import com.reservationapp.entity.Route;
import com.reservationapp.payload.RouteDto;
import com.reservationapp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/route")
public class RouteController {
    @Autowired
   private RouteService routeService;
    //http://localhost/8080/api/v1/route/1
    @PostMapping("/{busId}")
    public ResponseEntity<Route> addRoute(@PathVariable long busId, @RequestBody RouteDto routeDto){
        Route route = routeService.createRoute(busId, routeDto);
        return new ResponseEntity<>(route, HttpStatus.CREATED);



    }
}
