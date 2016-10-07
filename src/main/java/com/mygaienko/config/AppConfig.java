package com.mygaienko.config;

import org.springframework.context.annotation.*;

/**
 * Created by enda1n on 03.10.2016.
 */
@Configuration
@ComponentScan(basePackages = "com.mygaienko.controller")
@Import(SecurityConfig.class)
public class AppConfig {



    @Scope(scopeName = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Bean()
    public TT createB(){
        return new TT();
    }

    public static class  TT{
        public double value  = Math.random();

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
}
