package com.example.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource; //cia springas supras automatiskai, kad jungtis prie musu sukonfiguruotos DB

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //nurodome objekta, kuris bus atsakingas uz slaptazodzio uzkodavima (encodinima)
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "SELECT username, password, enabled from user where username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.username, a.authority " +
                                "FROM authority a, user u " +
                                "WHERE u.username = ? " +
                                "AND u.id = a.id"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.httpBasic(); //bus prasoma ivesti login/password narsykles pop upe
//        http.formatLogin(); //bus pateikta defaultine springo logino forma

        http
                .authorizeRequests()
                .antMatchers("/test/cattle/admin/**").hasAuthority("ADMIN")
                .antMatchers("/test/cattle/user/**").hasAuthority("USER")
                .antMatchers("/").permitAll();
    }
}
