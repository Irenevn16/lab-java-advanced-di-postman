package com.example.demo.configuration;

import com.example.demo.services.EarlyDiscountService;
import jdk.jfr.Category;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DiscountFeatureConfig {

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.enabled", havingValue = "true")
    public EarlyDiscountService earlyBirdDiscountService () {
        return new EarlyDiscountService();
    }

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.disabled", havingValue = "false", matchIfMissing = true)
    public EarlyDiscountService earlyBirdDiscountServiceDisabled () {
        return new EarlyDiscountService() {
            @Override
            public void noDiscount() {
                System.out.println("There is no discount with that booking date");
            }
        };
    }
}
