package com.wallet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
/**
 *  returns the current instant using the best available system clock
 */
@Configuration
public class ClockConfig {

    @Bean
    public Clock clock(){
        return Clock.systemUTC();
    }
}
