package com.gcosarba.orders;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class TestNotificationConstructor {

    @Test
    public void testConstructor() {
        Order expectedOrder = new Order(1,2);
        Notification expected = new Notification("topic", expectedOrder);
        assertEquals("topic", expected.getTopic());
        assertEquals(1, expected.getOrder().getApples());
        assertEquals(2, expected.getOrder().getOranges());
    }

}