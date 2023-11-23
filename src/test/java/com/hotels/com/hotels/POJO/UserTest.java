package com.hotels.com.hotels.POJO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class UserTest {


    // Creating a new User object with valid parameters should set the object's attributes correctly.
    @Test
    public void test_createUserWithValidParameters() {
        User user = new User("John Doe", "1234567890", "john.doe@example.com", "password", "active", "user");

        assertEquals("John Doe", user.getName());
        assertEquals("1234567890", user.getContactNumber());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals("active", user.getStatus());
        assertEquals("user", user.getRole());
    }

    // Retrieving the User's attributes using the getter methods should return the correct values.
    @Test
    public void test_getUserAttributes() {
        User user = new User("John Doe", "1234567890", "john.doe@example.com", "password", "active", "user");

        assertEquals("John Doe", user.getName());
        assertEquals("1234567890", user.getContactNumber());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals("active", user.getStatus());
        assertEquals("user", user.getRole());
    }

    // Creating a new User object with null or empty parameters should throw an IllegalArgumentException.
    @Test
    public void test_createUserWithNullParameters() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, "1234567890", "john.doe@example.com", "password", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", null, "john.doe@example.com", "password", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", null, "password", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "john.doe@example.com", null, "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "john.doe@example.com", "password", null, "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "john.doe@example.com", "password", "active", null));
        assertThrows(IllegalArgumentException.class, () -> new User("", "1234567890", "john.doe@example.com", "password", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "", "john.doe@example.com", "password", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "", "password", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "john.doe@example.com", "", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "john.doe@example.com", "password", "", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "john.doe@example.com", "password", "active", ""));
    }

    // Creating a new User object with an invalid email format should throw an IllegalArgumentException.
    @Test
    public void test_createUserWithInvalidEmailFormat() {
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "john.doe@example", "password", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "johndoe@example.com.", "password", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "john.doe@example..com", "password", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "@example.com", "password", "active", "user"));
        assertThrows(IllegalArgumentException.class, () -> new User("John Doe", "1234567890", "john.doe@examplecom", "password", "active", "user"));
    }

    // Updating the User's status using the setStatus() method with an invalid status value should throw an IllegalArgumentException.
    @Test
    public void test_updateUserStatusWithInvalidValue() {
        User user = new User("John Doe", "1234567890", "john.doe@example.com", "password", "active", "user");

        assertThrows(IllegalArgumentException.class, () -> user.setStatus("invalid_status"));
    }

}