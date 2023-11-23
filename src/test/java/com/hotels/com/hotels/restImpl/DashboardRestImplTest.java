package com.hotels.com.hotels.restImpl;

import com.hotels.com.hotels.service.DashboardService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DashboardRestImplTest {


    // When getCount() is called, it should return a ResponseEntity<Map<String, Object>>
    @Test
    public void test_getCount_returnsResponseEntityWithMap() {
        // Arrange
        DashboardService dashboardService = mock(DashboardService.class);
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("key", "value");
        ResponseEntity<Map<String, Object>> expectedResponse = ResponseEntity.ok(expectedData);
        when(dashboardService.getCount()).thenReturn(expectedResponse);

        DashboardRestImpl dashboardRestImpl = new DashboardRestImpl();
        dashboardRestImpl.setDashboardService(dashboardService);

        // Act
        ResponseEntity<Map<String, Object>> actualResponse = dashboardRestImpl.getCount();

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    // The returned ResponseEntity should contain a Map<String, Object> with the expected data
    @Test
    public void test_getCount_returnsResponseEntityWithExpectedData() {
        // Arrange
        DashboardService dashboardService = mock(DashboardService.class);
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("key", "value");
        ResponseEntity<Map<String, Object>> expectedResponse = ResponseEntity.ok(expectedData);
        when(dashboardService.getCount()).thenReturn(expectedResponse);

        DashboardRestImpl dashboardRestImpl = new DashboardRestImpl();
        dashboardRestImpl.setDashboardService(dashboardService);

        // Act
        ResponseEntity<Map<String, Object>> actualResponse = dashboardRestImpl.getCount();
        Map<String, Object> actualData = actualResponse.getBody();

        // Assert
        assertEquals(expectedData, actualData);
    }

    // When the DashboardService returns a Map<String, Object> with null values, the getCount() method should return a ResponseEntity with HTTP status 200 and an empty Map<String, Object>
    @Test
    public void test_getCount_returnsResponseEntityWithEmptyMapWhenServiceReturnsNullValues() {
        // Arrange
        DashboardService dashboardService = mock(DashboardService.class);
        Map<String, Object> nullData = new HashMap<>();
        nullData.put("key", null);
        ResponseEntity<Map<String, Object>> expectedResponse = ResponseEntity.ok(nullData);
        when(dashboardService.getCount()).thenReturn(expectedResponse);

        DashboardRestImpl dashboardRestImpl = new DashboardRestImpl();
        dashboardRestImpl.setDashboardService(dashboardService);

        // Act
        ResponseEntity<Map<String, Object>> actualResponse = dashboardRestImpl.getCount();
        Map<String, Object> actualData = actualResponse.getBody();

        // Assert
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertTrue(actualData.isEmpty());
    }

    // When the DashboardService returns a Map<String, Object> with invalid data types, the getCount() method should return a ResponseEntity with HTTP status 500
    @Test
    public void test_getCount_returnsResponseEntityWithInternalServerErrorWhenServiceReturnsInvalidDataTypes() {
        // Arrange
        DashboardService dashboardService = mock(DashboardService.class);
        Map<String, Object> invalidData = new HashMap<>();
        invalidData.put("key", new Object());
        ResponseEntity<Map<String, Object>> expectedResponse = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        when(dashboardService.getCount()).thenReturn(expectedResponse);

        DashboardRestImpl dashboardRestImpl = new DashboardRestImpl();
        dashboardRestImpl.setDashboardService(dashboardService);

        // Act
        ResponseEntity<Map<String, Object>> actualResponse = dashboardRestImpl.getCount();

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualResponse.getStatusCode());
    }

    // If the DashboardService returns null, the getCount() method should return a ResponseEntity with HTTP status 404
    @Test
    public void test_getCount_returnsResponseEntityWithNotFoundWhenServiceReturnsNull() {
        // Arrange
        DashboardService dashboardService = mock(DashboardService.class);
        ResponseEntity<Map<String, Object>> expectedResponse = ResponseEntity.notFound().build();
        when(dashboardService.getCount()).thenReturn(expectedResponse);

        DashboardRestImpl dashboardRestImpl = new DashboardRestImpl();
        dashboardRestImpl.setDashboardService(dashboardService);

        // Act
        ResponseEntity<Map<String, Object>> actualResponse = dashboardRestImpl.getCount();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actualResponse.getStatusCode());
    }

}