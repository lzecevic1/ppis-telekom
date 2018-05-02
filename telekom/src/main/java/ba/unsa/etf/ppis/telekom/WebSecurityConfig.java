package ba.unsa.etf.ppis.telekom;

import ba.unsa.etf.ppis.telekom.filters.JWTAuthenticationFilter;
import ba.unsa.etf.ppis.telekom.filters.JWTLoginFilter;
import ba.unsa.etf.ppis.telekom.services.CustomUserDetailsService;
import ba.unsa.etf.ppis.telekom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String ROLE_ADMIN = "ADMIN";
    private final String ROLE_SERVICE_USER = "SERVICER";
    private final String ROLE_SUPPLIER_USER = "SUPPLIER";

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
/*
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
*/

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
          //comming soon      .antMatchers()
                .antMatchers("/").permitAll()
                .anyRequest().permitAll();
                //.and()
                //.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                //.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }
}
