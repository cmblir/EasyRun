// src/main/java/com/example/controller/RouteController.java

package com.example.controller;

import com.example.service.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {

    private final GoogleMapsService googleMapsService;

    @Autowired
    public RouteController(GoogleMapsService googleMapsService) {
        this.googleMapsService = googleMapsService;
    }

    @GetMapping("/route")
    public String getOptimalRoute(@RequestParam Double startLatitude, @RequestParam Double startLongitude,
                                  @RequestParam Double destinationLatitude, @RequestParam Double destinationLongitude) {
        return googleMapsService.getRouteInfo(startLatitude, startLongitude, destinationLatitude, destinationLongitude);
    }
}
