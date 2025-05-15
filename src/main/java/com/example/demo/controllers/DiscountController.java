package com.example.demo.controllers;

import com.example.demo.services.DiscountService;
import com.example.demo.services.EarlyDiscountService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/api")
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping("/discount")
    public String applyDiscount (@RequestParam String eventDate, @RequestParam String bookingDate) {
        try {
            LocalDate event = LocalDate.parse(eventDate);
            LocalDate booking = LocalDate.parse(bookingDate);
            int discount = discountService.calculateDiscount(event, booking);

            if (discount > 0) {
                return "You can apply to a " + discount + "% discount.";
            } else {
                return discountService.noDiscount();
            }

        } catch (DateTimeException e) {
            return "Invalid date format, use : yyyy-MM-dd";
        }

    }

}
