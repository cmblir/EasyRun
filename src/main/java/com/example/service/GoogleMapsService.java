// src/main/java/com/example/service/GoogleMapsService.java

package com.example.service;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class GoogleMapsService {

    private final GeoApiContext geoApiContext;

    public GoogleMapsService() {
        this.geoApiContext = new GeoApiContext.Builder()
                .apiKey("AIzaSyDmAGCZiB7FwGqy30vnRUvt9mRXdwwAmXc")
                .build();
    }

    public String getRouteInfo(double startLatitude, double startLongitude,
                               double destinationLatitude, double destinationLongitude) {
        try {
            DirectionsResult directionsResult = DirectionsApi.newRequest(geoApiContext)
                    .mode(TravelMode.WALKING) // 걷는 경로로 설정 (RUNNING 또는 BICYCLING으로 변경 가능)
                    .origin(new com.google.maps.model.LatLng(startLatitude, startLongitude))
                    .destination(new com.google.maps.model.LatLng(destinationLatitude, destinationLongitude))
                    .await();

            if (directionsResult.routes.length > 0) {
                long distanceInMeters = directionsResult.routes[0].legs[0].distance.inMeters;
                long durationInSeconds = directionsResult.routes[0].legs[0].duration.inSeconds;

                double distanceInKm = distanceInMeters / 1000.0;
                long durationInMinutes = TimeUnit.SECONDS.toMinutes(durationInSeconds);

                return "Distance: " + distanceInKm + " km, Estimated Duration: " + durationInMinutes + " minutes";
            } else {
                return "No route found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred";
        }
    }
}
