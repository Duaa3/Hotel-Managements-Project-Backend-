package com.hotels.com.hotels.POJO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class BillTest {


    // Bill object can be created with all required fields
    @Test
    public void test_createBillWithRequiredFields() {
        Bill bill = new Bill();
        bill.setId(1);
        bill.setUuid("123456");
        bill.setName("John Doe");
        bill.setEmail("johndoe@example.com");
        bill.setContactNumber("1234567890");
        bill.setPaymentMethod("Credit Card");
        bill.setTotal(100);
        bill.setRoomDetails("{\"room\": \"101\"}");
        bill.setCreatedBy("admin");

        assertEquals(1, bill.getId());
        assertEquals("123456", bill.getUuid());
        assertEquals("John Doe", bill.getName());
        assertEquals("johndoe@example.com", bill.getEmail());
        assertEquals("1234567890", bill.getContactNumber());
        assertEquals("Credit Card", bill.getPaymentMethod());
        assertEquals(100, bill.getTotal());
        assertEquals("{\"room\": \"101\"}", bill.getRoomDetails());
        assertEquals("admin", bill.getCreatedBy());
    }

    // Bill object can be updated with new values for all fields
    @Test
    public void test_updateBillWithNewValuesForAllFields() {
        Bill bill = new Bill();
        bill.setId(1);
        bill.setUuid("123456");
        bill.setName("John Doe");
        bill.setEmail("johndoe@example.com");
        bill.setContactNumber("1234567890");
        bill.setPaymentMethod("Credit Card");
        bill.setTotal(100);
        bill.setRoomDetails("{\"room\": \"101\"}");
        bill.setCreatedBy("admin");

        bill.setId(2);
        bill.setUuid("654321");
        bill.setName("Jane Smith");
        bill.setEmail("janesmith@example.com");
        bill.setContactNumber("0987654321");
        bill.setPaymentMethod("PayPal");
        bill.setTotal(200);
        bill.setRoomDetails("{\"room\": \"202\"}");
        bill.setCreatedBy("user");

        assertEquals(2, bill.getId());
        assertEquals("654321", bill.getUuid());
        assertEquals("Jane Smith", bill.getName());
        assertEquals("janesmith@example.com", bill.getEmail());
        assertEquals("0987654321", bill.getContactNumber());
        assertEquals("PayPal", bill.getPaymentMethod());
        assertEquals(200, bill.getTotal());
        assertEquals("{\"room\": \"202\"}", bill.getRoomDetails());
        assertEquals("user", bill.getCreatedBy());
    }

    // Bill object can be created with null values for optional fields
    @Test
    public void test_createBillWithNullOptionalFields() {
        Bill bill = new Bill();
        bill.setId(1);
        bill.setUuid("123456");
        bill.setName("John Doe");
        bill.setEmail(null);
        bill.setContactNumber(null);
        bill.setPaymentMethod(null);
        bill.setTotal(100);
        bill.setRoomDetails("{\"room\": \"101\"}");
        bill.setCreatedBy("admin");

        assertNull(bill.getEmail());
        assertNull(bill.getContactNumber());
        assertNull(bill.getPaymentMethod());
    }

    // Bill object can be created with empty strings for optional fields
    @Test
    public void test_createBillWithEmptyOptionalFields() {
        Bill bill = new Bill();
        bill.setId(1);
        bill.setUuid("123456");
        bill.setName("John Doe");
        bill.setEmail("");
        bill.setContactNumber("");
        bill.setPaymentMethod("");
        bill.setTotal(100);
        bill.setRoomDetails("{\"room\": \"101\"}");
        bill.setCreatedBy("admin");

        assertEquals("", bill.getEmail());
        assertEquals("", bill.getContactNumber());
        assertEquals("", bill.getPaymentMethod());
    }

    // Bill object can be created with the minimum and maximum allowed values for total
    @Test
    public void test_createBillWithMinMaxTotalValues() {
        Bill bill = new Bill();
        bill.setId(1);
        bill.setUuid("123456");
        bill.setName("John Doe");
        bill.setEmail("johndoe@example.com");
        bill.setContactNumber("1234567890");
        bill.setPaymentMethod("Credit Card");
        bill.setTotal(Integer.MIN_VALUE);
        bill.setRoomDetails("{\"room\": \"101\"}");
        bill.setCreatedBy("admin");

        assertEquals(Integer.MIN_VALUE, bill.getTotal());

        bill.setTotal(Integer.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, bill.getTotal());
    }

}