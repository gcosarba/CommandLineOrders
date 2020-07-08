package com.gcosarba.notifications;

import com.gcosarba.orders.Order;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class TestOrderConstructor {

    @Test
    public void testConstructor() {
        String[] subscribers = {"customer", "inventoryService"};
        Order expectedOrder = new Order(1,2);
        Message expected = new Message(subscribers, expectedOrder);
        assertEquals("customer", expected.getSubscribers()[0]);
        assertEquals(1, expected.getOrder().getApples());
        assertEquals(2, expected.getOrder().getOranges());
    }
}