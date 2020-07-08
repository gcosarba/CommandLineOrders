package com.gcosarba.orders;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

// Model the resource
// Would eventually want to get a library to marshal/unmarshal this to JSON
public class Order {
    // Needs an ID here when storing in DB. Generated
    private final int apples;
    private final int oranges;

    public Order(int apples, int oranges) {
        this.apples = apples;
        this.oranges = oranges;
    }

    public Order(String[] inputs) {
        int appleCount = 0;
        int orangeCount = 0;
        for (String item : inputs) {
            if (item.equals("apple")) {
                appleCount++;
            } else if (item.equals("orange")) {
                orangeCount++;
            }
        }
        this.apples = appleCount;
        this.oranges = orangeCount;
    }

    public int getApples() {
        return apples;
    }

    public int getOranges() {
        return oranges;
    }

    public String orderTotal(){
        // Buy 1 get 1 = divide by 2 and add remainder.
        int appleCount = apples/2 + apples % 2;

        // Buy 2 get 1 = 2 * divide by 3 and add remainder
        int orangeCount = 2*(oranges/3) + oranges % 3;

        double sum = (appleCount * .60 + orangeCount * .25);
        NumberFormat usnf = NumberFormat.getCurrencyInstance(Locale.US);
        return(usnf.format(sum));
    }

    public boolean isEmpty(){
        return this.orderTotal().equals("$0.00");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getApples() == order.getApples() &&
                getOranges() == order.getOranges();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getApples(), getOranges());
    }

    @Override
    public String toString() {
        return "Order{" +
                "apples=" + apples +
                ", oranges=" + oranges +
                '}';
    }
}
