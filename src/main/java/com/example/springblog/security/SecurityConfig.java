package com.example.springblog.security;

import com.example.springblog.config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends /*WebConfig*/WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource datasource;

    @Autowired
    public void globalSecurityConfig(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(datasource)
                .usersByUsernameQuery("select email,password,'true' from user where email = ?")
                .authoritiesByUsernameQuery("select email,role from user where email = ?");
              //  .usersByUsernameQuery("select userName,password,'true' from user where userName = ?")
             //   .authoritiesByUsernameQuery("select userName,role from user where userName = ?");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/api/auth/signup").permitAll()
                .antMatchers("/api/post/addPost").permitAll()
                .antMatchers("/api/posts/addPost").permitAll()
                .antMatchers("/api/auth/getUserByEmail/**").permitAll()
                //            .antMatchers("/api/posts/addPostByPassingURI/**").permitAll()
                .antMatchers("/api/comment/**").permitAll()
                .antMatchers("/api/posts/addPostByPassingURI/**").permitAll()
                .antMatchers("/api/auth/all").permitAll()
                .antMatchers("/api/post/getUsersByMail/**").permitAll()
                .antMatchers("/api/post/getUserByToken/**").permitAll()
                .antMatchers("/api/post/getUserPostsByMail/**").permitAll()
                .antMatchers("/api/auth/getUserByMail/**").permitAll()
                .antMatchers("/api/auth/getUserByName/**").permitAll()
                .antMatchers("/api/post//deletePost/**").permitAll()
                .antMatchers("/api/post/filterByUser/**").permitAll()
                .antMatchers("/api/post/all").permitAll()
                .antMatchers("/api/auth/getUser/**").permitAll()
                .antMatchers("/api/posts/addPostByPassingURI/**").permitAll()
                .antMatchers("/api/auth/retrieveViaToken/**").permitAll()
                .anyRequest().authenticated().and().httpBasic();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
