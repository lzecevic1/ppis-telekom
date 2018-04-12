package ba.unsa.etf.ppis.telekom;

import ba.unsa.etf.ppis.telekom.filters.JWTAuthenticationFilter;
import ba.unsa.etf.ppis.telekom.filters.JWTLoginFilter;
import ba.unsa.etf.ppis.telekom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String ROLE_ADMIN = "ADMIN";
    private final String ROLE_SERVICE_USER = "SERVICE";
    private final String ROLE_SUPPLIER_USER = "SUPPLIER";

    @Autowired
    private UserService userService;

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
          //comming soon      .antMatchers()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JWTLoginFilter("/lgoin", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
}
