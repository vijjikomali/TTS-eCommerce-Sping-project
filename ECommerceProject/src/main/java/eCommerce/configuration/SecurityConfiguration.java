package eCommerce.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import eCommerce.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
@Autowired
private UserService userService;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
 
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
}
 
@Override
protected void configure(HttpSecurity http) throws Exception {
  http
      .authorizeRequests()
          .antMatchers("/cart").authenticated()
      .and().formLogin()
          .loginPage("/signin")
          .loginProcessingUrl("/login")
      .and().logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
          .logoutSuccessUrl("/");
}
}