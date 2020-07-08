package com.gcosarba.notifications;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Message is what the notification service sends to subscribers
 */
public class Message implements Serializable {
    private final String[] subscribers;
    private final String orderID;

    public Message(String[] subscribers, String orderID) {
        this.subscribers = subscribers;
        this.orderID = orderID;
    }

    public String[] getSubscribers() {
        return subscribers;
    }

    public String getOrderID() {
        return orderID;
    }

    public String storeMessage() throws IOException{
        String location = String.format("/tmp/message-%s.ser", this.orderID);
        System.out.println("Saving message in " + location);
        FileOutputStream fileOut = new FileOutputStream(location);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();


        return location;

    }

    @Override
    public String toString() {
        return "Message{" +
                "subscribers=" + Arrays.toString(subscribers) +
                ", orderID='" + orderID + '\'' +
                '}';
    }
}
