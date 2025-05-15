package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NoDiscountService implements DiscountService{

    @Override
    public int calculateDiscount(LocalDate eventDate, LocalDate bookingDate) {
        return 0;
    }

    @Override
    public String noDiscount() {
        return "Discounts are disabled.";
    }
}
