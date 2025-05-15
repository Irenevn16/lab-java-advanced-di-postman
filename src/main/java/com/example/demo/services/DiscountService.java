package com.example.demo.services;

import java.time.LocalDate;

public interface DiscountService {
    int calculateDiscount (LocalDate eventDate, LocalDate bookingDate);
    String noDiscount();
}
