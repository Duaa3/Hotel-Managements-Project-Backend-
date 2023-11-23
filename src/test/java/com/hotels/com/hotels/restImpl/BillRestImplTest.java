package com.hotels.com.hotels.restImpl;

import com.hotels.com.hotels.POJO.Bill;
import com.hotels.com.hotels.constents.HotelsConstants;
import com.hotels.com.hotels.service.BillService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class BillRestImplTest {


    // Should call BillService.generateReport with the given requestMap and return its response
    @Test
    public void test_generate_report() {
        // Arrange
        BillService billService = mock(BillService.class);
        BillRestImpl billRestImpl = new BillRestImpl();
        billRestImpl.billService = billService;
        Map<String, Object> requestMap = new HashMap<>();

        // Act
        billRestImpl.generateReport(requestMap);

        // Assert
        verify(billService).generateReport(requestMap);
    }

    // Should call BillService.getBills and return its response
    @Test
    public void test_get_bills() {
        // Arrange
        BillService billService = mock(BillService.class);
        BillRestImpl billRestImpl = new BillRestImpl();
        billRestImpl.billService = billService;

        // Act
        billRestImpl.getBills();

        // Assert
        verify(billService).getBills();
    }

    // Should return INTERNAL_SERVER_ERROR if an exception is thrown in generateReport
    @Test
    public void test_generate_report_exception() {
        // Arrange
        BillService billService = mock(BillService.class);
        BillRestImpl billRestImpl = new BillRestImpl();
        billRestImpl.billService = billService;
        Map<String, Object> requestMap = new HashMap<>();
        when(billService.generateReport(requestMap)).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<String> response = billRestImpl.generateReport(requestMap);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(HotelsConstants.SOMETHING_WENT_WRONG, response.getBody());
    }

    // Should return INTERNAL_SERVER_ERROR if an exception is thrown in getBills
    @Test
    public void test_get_bills_exception() {
        // Arrange
        BillService billService = mock(BillService.class);
        BillRestImpl billRestImpl = new BillRestImpl();
        billRestImpl.billService = billService;
        when(billService.getBills()).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<List<Bill>> response = billRestImpl.getBills();

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(new ArrayList<>(), response.getBody());
    }

    // Should return null if an exception is thrown in getPdf
    @Test
    public void test_get_pdf_exception() {
        // Arrange
        BillService billService = mock(BillService.class);
        BillRestImpl billRestImpl = new BillRestImpl();
        billRestImpl.billService = billService;
        Map<String, Object> requestMap = new HashMap<>();
        when(billService.getPdf(requestMap)).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<byte[]> response = billRestImpl.getPdf(requestMap);

        // Assert
        assertNull(response);
    }

}