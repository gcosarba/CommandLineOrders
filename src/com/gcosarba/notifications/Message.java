package com.gcosarba.notifications;

import com.gcosarba.orders.Order;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * Message is what the notification service sends to subscribers
 */
public class Message {
    private final String[] subscribers;
    private final Order order;

    public Message(String[] subscribers, Order order) {
        this.subscribers = subscribers;
        this.order = order;
    }

    public String[] getSubscribers() {
        return subscribers;
    }

    public Order getOrder() {
        return order;
    }

    public String storeMessage() throws IOException{
        String location = "/tmp/message.txt";

        FileOutputStream fileOut = new FileOutputStream(location);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
        System.out.println("Message was saved in " + location);

        return location;

    }

    @Override
    public String toString() {
        return "Message{" +
                "subscribers=" + Arrays.toString(subscribers) +
                ", order=" + order +
                '}';
    }
}
