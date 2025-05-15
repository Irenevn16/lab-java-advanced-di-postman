package com.example.demo.controllers;

import com.example.demo.services.EarlyDiscountService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/api")
public class DiscountController {

    private final EarlyDiscountService earlyDiscountService;

    @GetMapping("/discount")
    public int applyDiscount (@PathVariable Date eventDate, @PathVariable Date bookingDate) ´{

    }

}
