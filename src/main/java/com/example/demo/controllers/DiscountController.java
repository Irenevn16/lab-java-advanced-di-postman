package com.example.demo.controllers;

import com.example.demo.services.EarlyDiscountService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/api")
public class DiscountController {

    private final EarlyDiscountService earlyDiscountService;

    @GetMapping("/discount")
    public String applyDiscount (@RequestParam String eventDate, @RequestParam String bookingDate) {
        try {
            LocalDate event = LocalDate.parse(eventDate);
            LocalDate booking = LocalDate.parse(bookingDate);
            int discount = earlyDiscountService.calculateDiscount(event, booking);

            if (discount > 0) {
                return "You can apply to a " + discount + "% discount.";
            } else {
                return earlyDiscountService.noDiscount();
            }

        } catch (DateTimeException e) {
            return "Invalid date format, use : yyyy-MM-dd";
        }

    }

}
