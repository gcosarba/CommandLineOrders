package com.gcosarba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void happyPath() {
        String[] input = {"apple", "orange"};
        assertEquals("$0.85", Main.orderTotal(input));
    }

    @Test
    public void bogusInputIgnored() {
        String[] input = {"apple", "orange", "garbage", "bogus", "ignored"};
        assertEquals("$0.85", Main.orderTotal(input));
    }

    @Test
    public void noInputReturnsCorrectly() {
        String[] input = {};
        assertEquals("$0.00", Main.orderTotal(input));
    }

    @Test
    public void onlyBogusInputReturnsCorrectly() {
        String[] input = {"garbage", "bogus", "ignored", "1234"};
        assertEquals("$0.00", Main.orderTotal(input));
    }

    @Test
    public void largeOrder() {
        String[] input = {"apple", "orange", "apple", "orange", "apple", "orange", "apple", "orange", "apple", "orange", "apple", "orange"};
        assertEquals("$5.10", Main.orderTotal(input));
    }
}