// src/test/java/com/example/service/GoogleMapsServiceTest.java

package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GoogleMapsServiceTest {

    @Autowired
    private GoogleMapsService googleMapsService;

    @Test
    public void testGetRouteInfo() {
        double startLatitude = 37.7749; // San Francisco, CA
        double startLongitude = -122.4194;
        double destinationLatitude = 34.0522; // Los Angeles, CA
        double destinationLongitude = -118.2437;

        String routeInfo = googleMapsService.getRouteInfo(startLatitude, startLongitude, destinationLatitude, destinationLongitude);

        assertNotNull(routeInfo);
        // 여기서는 예상 결과에 따라 테스트를 진행합니다.
        // 실제 결과와 비교하여 테스트하는 것이 좋습니다.
        assertEquals("Distance: 615.0 km, Estimated Duration: 721 minutes", routeInfo);
    }
}
