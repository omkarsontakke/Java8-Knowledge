package org.example.JavaTheoryAndImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface
public interface UPIPayment {
    public String doPayment(String source, String destination);

    default double getCoupon() {
        return new Random().nextDouble();
    }

    static String datePattern(String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(new Date());
    }
}
