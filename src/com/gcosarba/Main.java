package com.gcosarba;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("Apples are now buy 1 get 1 free and oranges are buy 2 get 1 free");
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

        // Buy 1 get 1 = divide by 2 and add remainder.
        appleCount = appleCount/2 + appleCount % 2;

        // Buy 2 get 1 = 2 * divide by 3 and add remainder
        orangeCount = 2*(orangeCount/3) + orangeCount % 3;

        double sum = (appleCount * .60 + orangeCount * .25);
        NumberFormat usnf = NumberFormat.getCurrencyInstance(Locale.US);
        return(usnf.format(sum));
    }
}
