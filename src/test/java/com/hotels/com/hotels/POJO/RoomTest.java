package com.hotels.com.hotels.POJO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class RoomTest {


    // Creating a new instance of 'room' with valid parameters should return a valid object.
    @Test
    public void test_createValidRoomObject() {
        room roomObj = new room();
        roomObj.setId(1);
        roomObj.setName("Room 1");
        Hotel hotelObj = new Hotel();
        hotelObj.setId(1);
        hotelObj.setName("Hotel 1");
        roomObj.setHotel(hotelObj);
        roomObj.setDescription("This is a room");
        roomObj.setPrice(100);
        roomObj.setstatus("Available");

        assertNotNull(roomObj);
        assertEquals(1, roomObj.getId());
        assertEquals("Room 1", roomObj.getName());
        assertEquals(hotelObj, roomObj.getHotel());
        assertEquals("This is a room", roomObj.getDescription());
        assertEquals(100, roomObj.getPrice());
        assertEquals("Available", roomObj.getstatus());
    }

    // Setting and getting the 'id' field of a 'room' object should work correctly.
    @Test
    public void test_setAndGetId() {
        room roomObj = new room();
        roomObj.setId(1);

        assertEquals(1, roomObj.getId());
    }

    // Creating a new instance of 'room' with invalid parameters should throw an exception.
    @Test
    public void test_createInvalidRoomObject() {
        assertThrows(Exception.class, () -> {
            room roomObj = new room();
            roomObj.setId(null);
            roomObj.setName(null);
            roomObj.setHotel(null);
            roomObj.setDescription(null);
            roomObj.setPrice(null);
            roomObj.setstatus(null);
        });
    }

    // Setting the 'id' field of a 'room' object to an invalid value should throw an exception.
    @Test
    public void test_setInvalidId() {
        assertThrows(Exception.class, () -> {
            room roomObj = new room();
            roomObj.setId(-1);
        });
    }

    // Setting the 'name' field of a 'room' object to an invalid value should throw an exception.
    @Test
    public void test_setInvalidName() {
        assertThrows(Exception.class, () -> {
            room roomObj = new room();
            roomObj.setName("");
        });
    }

}