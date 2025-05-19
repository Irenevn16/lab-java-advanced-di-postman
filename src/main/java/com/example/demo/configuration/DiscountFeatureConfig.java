package com.example.demo.configuration;

import com.example.demo.services.EarlyDiscountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountFeatureConfig {

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.enabled", havingValue = "true")
    public EarlyDiscountService earlyBirdDiscountService () {
        return new EarlyDiscountService();
    }

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.enabled", havingValue = "false", matchIfMissing = true)
    public EarlyDiscountService noDiscountService() {
        return new EarlyDiscountService();
    }
}
