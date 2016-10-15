package com.mygaienko;

import com.mygaienko.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * http://localhost:8080/login
 *
 *
 *
 * localhost:8080/bentity/export/BENTITY_CSV
 * localhost:8080/aentity/export/AENTITY_CSV
 *
 * Created by enda1n on 03.10.2016.
 */
@SpringBootApplication
@EnableWebMvc
//@EnableAutoConfiguration
@Import(AppConfig.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
