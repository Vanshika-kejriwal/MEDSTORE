package com.medicalstore.medicalstore;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class webSecurity extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private DataSource dataSource;

    @Autowired 
    public void configAuthentication(AuthenticationManagerBuilder authBuilder)
    throws Exception {
        authBuilder.jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(new BCryptPasswordEncoder())
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, role from users where username=?")
            ;
    }   

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .csrf().disable()
        .authorizeRequests()
            .antMatchers("/profile/*","/orders/*").hasRole("USER")
            .anyRequest().permitAll()
            .and()
            .formLogin()
            // .defaultSuccessUrl("/")
            .loginPage("/login")
            .defaultSuccessUrl("/")
            // .usernameParameter("username")
            .permitAll()
            .and()
            .logout().permitAll()
            ;
    }

    



}
