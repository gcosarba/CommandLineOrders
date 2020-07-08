package com.gcosarba.orders;

import java.util.Objects;

/**
 * Notification is what the orders service sends to the notification service
 */
public class Notification {
    // Generated ID here
    private final String topic;
    private final Order order;

    public Notification(String topic, Order order) {
        this.topic = topic;
        this.order = order;
    }

    public String getTopic() {
        return topic;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(getTopic(), that.getTopic()) &&
                Objects.equals(getOrder(), that.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopic(), getOrder());
    }

    @Override
    public String toString() {
        return "Notification{" +
                "topic='" + topic + '\'' +
                ", order=" + order +
                '}';
    }
}
