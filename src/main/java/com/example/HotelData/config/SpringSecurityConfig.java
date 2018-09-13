package com.example.HotelData.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	@Value("${spring.basic.admin_username}")
	String admin_username;
	@Value("${spring.basic.admin_password}")
	String admin_password;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic()
				.authenticationEntryPoint(authEntryPoint);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> mngConfig = auth.inMemoryAuthentication();

		String password = "127ynre45";

		String encrytedPassword = this.passwordEncoder().encode(password);
		UserDetails user1 = User.withUsername("nanda").password(encrytedPassword).roles("USER").build();
		UserDetails user2 = User.withUsername(admin_username).password(this.passwordEncoder().encode(admin_password)).roles("ADMIN").build();

		mngConfig.withUser(user1);
		mngConfig.withUser(user2);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}