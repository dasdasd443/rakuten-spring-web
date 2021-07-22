package com.web.rakuten;

import com.web.rakuten.Service.RakutenUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class RakutechWebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private RakutenUserDetailsService rakutenUserDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.userDetailsService(rakutenUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    // Use this method to disable spring security
    // @Override
    // public void configure(HttpSecurity security) throws Exception {
    //     // TODO Auto-generated method stub
    //     security.httpBasic().disable();
    // }
}
