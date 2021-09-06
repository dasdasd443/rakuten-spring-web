package com.web.rakuten;

import com.Filter.jwtFilter;
import com.web.rakuten.Service.RakutenUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.Filter") 
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

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManagerBean();
    }

    // @Autowired
    // private jwtFilter jwtFilter;

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     // TODO Auto-generated method stub
    //     http.csrf().disable().authorizeRequests().antMatchers("/user/authenticate").permitAll().anyRequest().authenticated()
    //     .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    //     http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    // }

    

    


    // Use this method to disable spring security
    // @Override
    // public void configure(HttpSecurity security) throws Exception {
    //     // TODO Auto-generated method stub
    //     security.httpBasic().disable();
    // }

    // Use this method for basic spring security
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.authorizeRequests()
        .antMatchers("/css/**").permitAll()
        .antMatchers("/images/**").permitAll()
        .antMatchers("/product/**").permitAll()
        .antMatchers("/js/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and()
        .csrf().disable();
    }
}
