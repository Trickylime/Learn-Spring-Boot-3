package com.in28minutes.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void test() {
        assertTrue(todos.contains("AWS"), "Error Message");
        assertFalse(todos.contains("GCP"), "Error Message");

        assertArrayEquals(new int[] {1,2}, new int[] {1,2});

        assertEquals(3, todos.size(), "Error Message");
    }


}