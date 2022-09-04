package com.example.fisherbooker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.fisherbooker.security.auth.RestAuthenticationEntryPoint;
import com.example.fisherbooker.security.auth.TokenAuthenticationFilter;
import com.example.fisherbooker.service.impl.CustomAccountDetailsService;
import com.example.fisherbooker.util.TokenUtils;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private CustomAccountDetailsService customAccountDetailsService;

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customAccountDetailsService).passwordEncoder(passwordEncoder());
	}

	@Autowired
	private TokenUtils tokenUtils;

	// Definisemo prava pristupa za zahteve ka odredjenim URL-ovima/rutama
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

				// sve neautentifikovane zahteve obradi uniformno i posalji 401 gresku
				.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()

			// svim korisnicima dopusti da pristupe sledecim putanjama:
			.authorizeRequests().antMatchers("/auth/**").permitAll()
								.antMatchers("/h2-console/**").permitAll()
								.antMatchers("/api/cottage/**").permitAll()
								.antMatchers("/api/ship/**").permitAll()
								.antMatchers("/api/adventure/**").permitAll()
								.antMatchers("/api/instructor/**").permitAll()
								.antMatchers("/api/cottageOwner/**").permitAll()
								.antMatchers("/api/shipOwner/**").permitAll()
								.antMatchers("/api/client/**").permitAll()

								.antMatchers("/api/adventurereservation/**").permitAll()
								.antMatchers("/api/account/**").permitAll()
								.antMatchers("/api/admin/**").permitAll()

								.antMatchers("/api/verify/**").permitAll()
								.antMatchers("/api/registration/**").permitAll()
								.antMatchers("/api/review/**").permitAll()
								.antMatchers("/api/complaint/**").permitAll()

							

				// ukoliko ne zelimo da koristimo @PreAuthorize anotacije nad metodama
				// kontrolera, moze se iskoristiti hasRole() metoda da se ogranici
				// koji tip korisnika moze da pristupi odgovarajucoj ruti. Npr. ukoliko zelimo
				// da definisemo da ruti 'admin' moze da pristupi
				// samo korisnik koji ima rolu 'ADMIN', navodimo na sledeci nacin:
				// .antMatchers("/admin").hasRole("ADMIN") ili
				// .antMatchers("/admin").hasAuthority("ROLE_ADMIN")

				// za svaki drugi zahtev korisnik mora biti autentifikovan
				.anyRequest().authenticated().and()

				// za development svrhe ukljuci konfiguraciju za CORS iz WebConfig klase
				.cors().and()

				// umetni custom filter TokenAuthenticationFilter kako bi se vrsila provera JWT
				// tokena umesto cistih korisnickog imena i lozinke (koje radi
				// BasicAuthenticationFilter)
				.addFilterBefore(new TokenAuthenticationFilter(tokenUtils, customAccountDetailsService),
						BasicAuthenticationFilter.class);

		// zbog jednostavnosti primera ne koristimo Anti-CSRF token
		// (https://cheatsheetseries.owasp.org/cheatsheets/Cross-Site_Request_Forgery_Prevention_Cheat_Sheet.html)
		http.csrf().disable();
	}

	// Definisanje konfiguracije koja utice na generalnu bezbednost aplikacije
	@Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring().antMatchers(HttpMethod.POST, "/auth/login");

		web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "favicon.ico", "/**/*.html",
				"/**/*.css", "/**/*.js");
	}
}
