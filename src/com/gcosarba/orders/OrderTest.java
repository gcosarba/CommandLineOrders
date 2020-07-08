package com.gcosarba.orders;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class TestOrderConstructor {

    @Test
    public void testArgsConstructor() {
        String[] input = {"apple", "orange"};
        Order expected = new Order(input);
        assertEquals(1, expected.getApples());
        assertEquals(1, expected.getOranges());
    }

    @Test
    public void testArgsConstructorLargeOrder() {
        String[] input = {"apple", "apple", "apple", "apple", "apple", "apple", "orange", "orange", "orange"};
        Order expected = new Order(input);
        assertEquals(6, expected.getApples());
        assertEquals(3, expected.getOranges());
    }

    @Test
    public void testArgsConstructorBogusInputIgnored() {
        String[] input = {"apple", "orange", "garbage", "bogus", "ignored"};
        Order expected = new Order(input);
        assertEquals(1, expected.getApples());
        assertEquals(1, expected.getOranges());
    }

    @Test
    public void testArgsConstructorNoInput() {
        String[] input = {};
        Order expected = new Order(input);
        assertEquals(0, expected.getApples());
        assertEquals(0, expected.getOranges());
    }

    @Test
    public void testArgsConstructorOnlyBogusInput() {
        String[] input = {"garbage", "bogus", "ignored", "1234"};
        Order expected = new Order(input);
        assertEquals(0, expected.getApples());
        assertEquals(0, expected.getOranges());
    }
}

class testOrderTotal {
    @Test
    public void buyOneGetOne2Apples() {
        // Only 1 apple should be free
        Order order = new Order(2, 0);
        assertEquals("$0.60", order.orderTotal());
    }

    @Test
    public void buyOneGetOne3Apples() {
        // Only 1 apple should be free
        Order order = new Order(3, 0);
        assertEquals("$1.20", order.orderTotal());
    }

    @Test
    public void buyTwoGetOne3Oranges() {
        // Only 1 orange should be free
        Order order = new Order(0, 3);
        assertEquals("$0.50", order.orderTotal());
    }

    @Test
    public void buyTwoGetOne4Oranges() {
        // Only 1 orange should be free
        Order order = new Order(0, 4);
        assertEquals("$0.75", order.orderTotal());
    }

    @Test
    public void testBothPromos() {
        // 1 orange and 1 apple should be free
        Order order = new Order(2, 3);
        assertEquals("$1.10", order.orderTotal());
    }

    @Test
    public void testNoPromos() {
        // nothing should be free
        Order order = new Order(1, 2);
        assertEquals("$1.10", order.orderTotal());
    }

    @Test
    public void orderTotalZero() {
        Order order = new Order(0, 0);
        assertEquals("$0.00", order.orderTotal());
    }

    @Test
    public void testIsEmpty() {
        Order order = new Order(0, 0);
        assertTrue(order.isEmpty());
    }
}