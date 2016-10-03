package com.mygaienko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by enda1n on 03.10.2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                    .maximumSessions(1)/*.expiredUrl("")*/
                    .and()
                    .sessionFixation().migrateSession()
                .and()
                .authorizeRequests()
                    .antMatchers("/css/**", "/index").permitAll()
                    .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin()
                    .loginPage("/login").failureUrl("/login-error")
                .and()
                .rememberMe().tokenValiditySeconds(6000);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }
}
