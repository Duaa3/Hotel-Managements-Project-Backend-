package com.hotels.com.hotels.restImpl;

import com.hotels.com.hotels.service.roomService;
import com.hotels.com.hotels.wrapper.roomWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;



public class RoomrestimplTest {


    // When addNewRoom is called with valid input, it should call the corresponding method in roomService and return a success response
    @Test
    public void test_addNewRoom_validInput() {
        // Arrange
        Map<String, String> requestMap = new HashMap<>();
        // Add valid input to requestMap

        // Mock roomService
        roomService mockRoomService = Mockito.mock(roomService.class);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Success", HttpStatus.OK);
        Mockito.when(mockRoomService.addNewRoom(requestMap)).thenReturn(expectedResponse);

        // Create instance of roomRestImpl
        roomRestImpl roomRestImpl = new roomRestImpl();
        roomRestImpl.setRoomService(mockRoomService);

        // Act
        ResponseEntity<String> actualResponse = roomRestImpl.addNewRoom(requestMap);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    // When getAllRoom is called, it should call the corresponding method in roomService and return a list of all rooms
    @Test
    public void test_getAllRoom() {
        // Arrange
        List<roomWrapper> expectedRooms = new ArrayList<>();
        // Add expected rooms

        // Mock roomService
        roomService mockRoomService = Mockito.mock(roomService.class);
        ResponseEntity<List<roomWrapper>> expectedResponse = new ResponseEntity<>(expectedRooms, HttpStatus.OK);
        Mockito.when(mockRoomService.getAllRoom()).thenReturn(expectedResponse);

        // Create instance of roomRestImpl
        roomRestImpl roomRestImpl = new roomRestImpl();
        roomRestImpl.setRoomService(mockRoomService);

        // Act
        ResponseEntity<List<roomWrapper>> actualResponse = roomRestImpl.getAllRoom();

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    // When addNewRoom is called with invalid input, it should return an error response
    @Test
    public void test_addNewRoom_invalidInput() {
        // Arrange
        Map<String, String> requestMap = new HashMap<>();
        // Add invalid input to requestMap

        // Mock roomService
        roomService mockRoomService = Mockito.mock(roomService.class);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
        Mockito.when(mockRoomService.addNewRoom(requestMap)).thenReturn(expectedResponse);

        // Create instance of roomRestImpl
        roomRestImpl roomRestImpl = new roomRestImpl();
        roomRestImpl.setRoomService(mockRoomService);

        // Act
        ResponseEntity<String> actualResponse = roomRestImpl.addNewRoom(requestMap);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    // When update is called with invalid input, it should return an error response
    @Test
    public void test_update_invalidInput() {
        // Arrange
        Map<String, String> requestMap = new HashMap<>();
        // Add invalid input to requestMap

        // Mock roomService
        roomService mockRoomService = Mockito.mock(roomService.class);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
        Mockito.when(mockRoomService.update(requestMap)).thenReturn(expectedResponse);

        // Create instance of roomRestImpl
        roomRestImpl roomRestImpl = new roomRestImpl();
        roomRestImpl.setRoomService(mockRoomService);

        // Act
        ResponseEntity<String> actualResponse = roomRestImpl.update(requestMap);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    // When delete is called with an invalid room id, it should return an error response
    @Test
    public void test_delete_invalidRoomId() {
        // Arrange
        Integer roomId = 123; // Invalid room id

        // Mock roomService
        roomService mockRoomService = Mockito.mock(roomService.class);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
        Mockito.when(mockRoomService.delete(roomId)).thenReturn(expectedResponse);

        // Create instance of roomRestImpl
        roomRestImpl roomRestImpl = new roomRestImpl();
        roomRestImpl.setRoomService(mockRoomService);

        // Act
        ResponseEntity<String> actualResponse = roomRestImpl.delete(roomId);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

}