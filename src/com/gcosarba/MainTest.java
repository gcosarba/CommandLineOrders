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
    public void buyOneGetOne2Apples() {
        // Only 1 apple should be free
        String[] input = {"apple", "apple"};
        assertEquals("$0.60", Main.orderTotal(input));
    }

    @Test
    public void buyOneGetOne3Apples() {
        // Only 1 apple should be free
        String[] input = {"apple", "apple", "apple"};
        assertEquals("$1.20", Main.orderTotal(input));
    }

    @Test
    public void buyTwoGetOne3Oranges() {
        // Only 1 orange should be free
        String[] input = {"orange", "orange", "orange"};
        assertEquals("$0.50", Main.orderTotal(input));
    }

    @Test
    public void buyTwoGetOne4Oranges() {
        // Only 1 orange should be free
        String[] input = {"orange", "orange", "orange", "orange"};
        assertEquals("$0.75", Main.orderTotal(input));
    }
}