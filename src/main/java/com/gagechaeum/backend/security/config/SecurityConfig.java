package com.gagechaeum.backend.security.config;

import com.gagechaeum.backend.security.filter.AuthenticationErrorFilter;
import com.gagechaeum.backend.security.filter.JwtAuthenticationFilter;
import com.gagechaeum.backend.security.filter.JwtEmailPasswordAuthenticationFilter;
import com.gagechaeum.backend.security.handler.*;
import com.gagechaeum.backend.user.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@Slf4j
// 매퍼 스캔 경로 확장
@MapperScan(basePackages = {
        "com.gagechaeum.backend.security.account.mapper",

})
@ComponentScan(basePackages = {"com.gagechaeum.backend.security"})
@PropertySource("classpath:/application.properties")
@RequiredArgsConstructor
@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationErrorFilter authenticationErrorFilter;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;
    private final LoginSuccessHandler loginSuccessHandler;
    private final LoginFailureHandler loginFailureHandler;
    private final UserDetailsService userDetailsService;
    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        // TODO: 운영 도메인 추가
        config.setAllowedOrigins(List.of(
                "http://localhost:5173"
        ));
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        // AT 전달용
        config.setExposedHeaders(List.of("Authorization"));

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("SecurityConfig - configure(AuthenticationManagerBuilder) 호출");
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        // 정적/스웨거만 시큐리티 무시
        web.ignoring().antMatchers(
                "/assets/**",
                "/favicon.ico",
                "/swagger-ui.html", "/swagger-ui/**",
                "/swagger-resources/**",
                "/v2/api-docs", "/v3/api-docs/**",
                "/webjars/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(encodingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authenticationErrorFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(
                        jwtEmailPasswordAuthenticationFilter(
                                loginSuccessHandler, loginFailureHandler, authenticationManagerBean()
                        ),
                        UsernamePasswordAuthenticationFilter.class
                )
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // 인증 불필요 경로
                .antMatchers(HttpMethod.POST, "/api/me/signup").permitAll()
                .antMatchers(HttpMethod.GET,  "/api/me/email-check").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/me/password-reset").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth/test-login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth/refresh").permitAll()
                .antMatchers("/login/oauth2/**", "/oauth2/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/chatrooms").permitAll()
                .antMatchers("/api/me/email/verify/**").permitAll()
                .antMatchers("/ws-stomp/**").permitAll() // JwtHandshakeInterceptor에서 보안 검사

                // 그 외는 기본 차단(로그인 필요)
                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2Login()
                .successHandler(oAuth2LoginSuccessHandler)
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }

    @Bean
    public JwtEmailPasswordAuthenticationFilter jwtEmailPasswordAuthenticationFilter(
            LoginSuccessHandler loginSuccessHandler,
            LoginFailureHandler loginFailureHandler,
            AuthenticationManager authenticationManager
    ) {
        JwtEmailPasswordAuthenticationFilter filter =
                new JwtEmailPasswordAuthenticationFilter(loginSuccessHandler, loginFailureHandler);
        filter.setAuthenticationManager(authenticationManager);
        // 로그인 URL
        filter.setFilterProcessesUrl("/api/auth/login");
        return filter;
    }
}
