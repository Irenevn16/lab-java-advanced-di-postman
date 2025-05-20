package com.example.demo.services;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


//no poner service pq es bean personalizada
public class EarlyDiscountService {

    public int calculateDiscount (LocalDate eventDate, LocalDate bookingDate) {
        long daysDifference = ChronoUnit.DAYS.between(bookingDate, eventDate);

        if (daysDifference >= 30) {
            return 15;
        } else if (daysDifference >= 20){
            return 10;
        } else {
            return 0;
        }
    }

    public String noDiscount() {
        return "There is no discount for the booking date selected.";
    }


}


