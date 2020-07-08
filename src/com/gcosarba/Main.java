package com.gcosarba;

import com.gcosarba.notifications.Message;
import com.gcosarba.notifications.NotificationMetadataService;
import com.gcosarba.orders.Notification;
import com.gcosarba.orders.Order;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    /**
     *
     * By the time the request his this service I would hope it has gone through an API gateway:
     * Request Validation
     * Authentication/Authorization: Determine if the request is allowed to hit the end point it wants before it hits it
     * Rate Limiting: Prevent DDoS. Throttle users abusing service
     * Routing: Have gateway make calls to all relevant services instead of client and consolidate response.
     * Caching: For data that only needs to be recalculated periodically, return cached response instead of calling service
     * Load balancing: If we need to scale a particular service, we need something to manage sending request across instances
     *
     */

    public static void main(String[] args) {
        // Instance the order
        Order order = new Order(args);
        // Don't process empty orders
        if(order.isEmpty()){
            System.out.println("Invalid order. Please order at least one item.");
            System.exit(0);
        }
        System.out.println("Your order total is: " + order.orderTotal());

        // TODO insert order into DB

        // Right now all we need to succeed is a valid order. Notify customer.
        // Perhaps this should just have an order ID instead of the entire order
        Notification notification = new Notification("orderProcessed", order);

        // Marshall JSON and send to notification service which for now is just a function
        notificationService(notification);
    }

    /**
     * NotificationService should have 3 functions:
     * 1. publish
     * 2. create a topic
     * 3. add subscriber to topic
     *
     * @param notification
     */
    public static void notificationService(Notification notification) {
        // TODO add loadbalancer

        /** make call to metadata service. Just an object for now
        * This service gives us access to the metadata DB through a well defined interface to simply future
        * development. This service can also act as a caching layer.
        */
        NotificationMetadataService metadata = new NotificationMetadataService();

        /**
         * In order to ensure each subscribers gets every messages at least once we need to put the message in
         * temporary storage so the sender can retry it if it fails. For now we'll serialize it locally
         */
        String[] subscribers = metadata.getTopics().get(notification.getTopic());
        Message message = new Message(subscribers, notification.getOrder().getID());

        // Not working :(
        try {
            message.storeMessage();
        }catch (IOException e){
            System.out.println("Failed to store message");
        }

        /**
         * Time to send the message to all our subs with retry. For now its a print :)
         * This should be deserializing from storage and getting the list of subscribers
         */
        for(String item : subscribers){
            //Replace with call to appropriate message queue or endpoint
            System.out.println("Your order has been successfully processed");
        }
    }

}
