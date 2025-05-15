package com.example.demo.configuration;

import com.example.demo.services.DiscountService;
import com.example.demo.services.EarlyDiscountService;
import com.example.demo.services.NoDiscountService;
import jdk.jfr.Category;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DiscountFeatureConfig {

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.enabled", havingValue = "true")
    public DiscountService earlyBirdDiscountService () {
        return new EarlyDiscountService();
    }

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.disabled", havingValue = "false", matchIfMissing = true)
    public DiscountService noDiscountService() {
        return new NoDiscountService();
    }
}
