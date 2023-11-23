package com.hotels.com.hotels.POJO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class HotelTest {


    // Hotel object can be created with a name and an id
    @Test
    public void test_createHotelWithNameAndId() {
        Hotel hotel = new Hotel();
        hotel.setId(1);
        hotel.setName("Hotel A");

        assertEquals(1, hotel.getId());
        assertEquals("Hotel A", hotel.getName());
    }

    // getName() method returns the name of the hotel
    @Test
    public void test_getName() {
        Hotel hotel = new Hotel();
        hotel.setName("Hotel A");

        assertEquals("Hotel A", hotel.getName());
    }

    // Hotel object can be created with a null name
    @Test
    public void test_createHotelWithNullName() {
        Hotel hotel = new Hotel();
        hotel.setId(1);
        hotel.setName(null);

        assertEquals(1, hotel.getId());
        assertNull(hotel.getName());
    }

    // Hotel object can be created with a null id
    @Test
    public void test_createHotelWithNullId() {
        Hotel hotel = new Hotel();
        hotel.setId(null);
        hotel.setName("Hotel A");

        assertNull(hotel.getId());
        assertEquals("Hotel A", hotel.getName());
    }

    // Hotel object can be created with an empty name
    @Test
    public void test_createHotelWithEmptyName() {
        Hotel hotel = new Hotel();
        hotel.setId(1);
        hotel.setName("");

        assertEquals(1, hotel.getId());
        assertEquals("", hotel.getName());
    }

}