package br.com.fabio.loanapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/customers/registerCustomer").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/logins//validateLogin").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/v1/logins/updateLogin")
                .hasAnyRole("CUSTOMER","ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/customers/listAllCustomers").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/customers/seeRegisterCustomer/*")
                .hasAnyRole("CUSTOMER","ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/customers/updateRegisterCustomer/*")
                .hasAnyRole("CUSTOMER","ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/customers/cancelRegisterCustomer/*")
                .hasAnyRole("CUSTOMER","ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/loans/requestLoan/*").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/api/v1/loans/listAllLoans").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/loans/listAllLoansByCustomer")
                .hasAnyRole("CUSTOMER","ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/loans/detailsLoanByCustomer")
                .hasAnyRole("CUSTOMER","ADMIN")
                .anyRequest().authenticated()
                .and().httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/static/**");
    }
}
