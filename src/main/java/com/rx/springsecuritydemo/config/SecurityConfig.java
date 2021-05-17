package com.rx.springsecuritydemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true , prePostEnabled = true)
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    RxUserDetailsService userDetailsService;
    @Autowired
    DataSource dataSource;
    @Autowired
    PersistentTokenRepository persistentTokenRepository;

    @Bean
    PersistentTokenRepository persistentTokenRepository(){
        log.warn("加载记住登录----");
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

//    @Autowired
//    BCryptPasswordEncoder passwordEncoder;

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.exceptionHandling().accessDeniedPage("/unauth.html");


        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/u/login")
                .defaultSuccessUrl("/home.html")
                .and().logout().logoutUrl("/logout2").logoutSuccessUrl("/logout_success.html").permitAll()
        .and().authorizeRequests()
                .antMatchers("/test1/t1" ,"/test1/t3" , "/login.html" , "/u/login","/unauth.html").permitAll()
                .antMatchers("/book").hasAuthority("book")
                .anyRequest().authenticated()
        .and().csrf().disable()
        ;
        http.rememberMe().tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(30)
                .userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
