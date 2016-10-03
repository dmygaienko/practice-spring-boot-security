package com.mygaienko.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by enda1n on 03.10.2016.
 */
@Configuration
@ComponentScan(basePackages = "com.mygaienko.controller")
@Import(SecurityConfig.class)
public class AppConfig {
}
