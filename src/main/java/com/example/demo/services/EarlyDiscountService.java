package com.example.demo.services;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Service
public class EarlyDiscountService implements DiscountService {
    @Override
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
    @Override
    public String noDiscount() {
        return "Please check your booking date, you may apply to a discount";
    }
}
