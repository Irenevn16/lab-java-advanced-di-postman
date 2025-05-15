package com.example.demo.services;


import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EarlyDiscountService {

    public void calculateDiscount (Date eventDate, Date bookingDate) {
        if ((bookingDate - eventDate) >= 30) {
            System.out.println("You can apply to a 15% discount");
        } else if ((bookingDate - eventDate) >= 20){
            System.out.println("You can apply to a 10% discount");
        } else {
            System.out.println("You can't apply to a discount");
        }
    }
}
