package com.gcosarba;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("Your order total is: " + orderTotal(args));
    }

    public static String orderTotal(String[] args) {
        int appleCount = 0;
        int orangeCount = 0;
        for (String item : args) {
            if (item.equals("apple")) {
                appleCount++;
            } else if (item.equals("orange")) {
                orangeCount++;
            }
        }
        double sum = (appleCount * .60 + orangeCount * .25);
        NumberFormat usnf = NumberFormat.getCurrencyInstance(Locale.US);
        return(usnf.format(sum));
    }
}
