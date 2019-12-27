package com.michcinski.demo.config;

import com.michcinski.demo.model.BlogUser;
import com.michcinski.demo.repository.UserRepo;
import com.michcinski.demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserRepo userRepo;
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService,UserRepo userRepo){
        this.userDetailsService = userDetailsService;
        this.userRepo = userRepo;
    }

    @Override
    protected void  configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("ADMIN","USER")
                .antMatchers("/editPost/{id}","/deletePost/{id}").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void save(){
        BlogUser blogUser = new BlogUser("Jan",passwordEncoder().encode("Nowak"),"ROLE_USER");
        BlogUser blogUser2 = new BlogUser("Pawel",passwordEncoder().encode("Michciu10"),"ROLE_ADMIN");
        userRepo.save(blogUser);
        userRepo.save(blogUser2);
    }

}
