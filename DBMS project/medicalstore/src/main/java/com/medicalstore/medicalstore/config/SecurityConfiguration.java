package com.medicalstore.medicalstore.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.medicalstore.medicalstore.Service.usersService;
import com.medicalstore.medicalstore.Service.usersServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Autowired
    DataSource dataSource;

    
//     @Override
//     public void configure(AuthenticationManagerBuilder auth) throws Exception{
//         auth.jdbcAuthentication()
//             .dataSource(dataSource)
//             .usersByUsernameQuery("select username,password,enabled from users where username=?")
//             .authoritiesByUsernameQuery("select username,role from users where username =?");
            
//    }
    // @Bean
    // public BCryptPasswordEncoder encoder(){
    //     return new BCryptPasswordEncoder();
    // }

    // @Autowired
    // usersServiceImpl usersservice;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    userdetailservice uds;

    @Bean
   public DaoAuthenticationProvider authProvider(){
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    authenticationProvider.setUserDetailsService(uds);
    return authenticationProvider;
   }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        // auth.userDetailsService(usersservice);
        auth.authenticationProvider(authProvider());
            
    }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/forgotpassword").permitAll()
            .antMatchers("/profile").hasRole("USER")
            .antMatchers("/success").hasAnyRole("ADMIN","USER")
            .antMatchers("/**").permitAll()
            .and()
            .formLogin()
            .loginPage("/login").permitAll()
            ;
   }

   
   
//    @Bean
//     public PasswordEncoder getPasswordEncoder() {
//         return NoOpPasswordEncoder.getInstance();
//     }

    
}
