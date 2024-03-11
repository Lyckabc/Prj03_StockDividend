package com.dayone.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationFilter authenticationFilter;

    // HTTP 보안 설정을 구성합니다.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // HTTP 기본 인증을 비활성화합니다.
                .httpBasic().disable()
                // CSRF(Cross-Site Request Forgery) 보호를 비활성화합니다.
                .csrf().disable()
                // 세션 관리를 상태를 유지하지 않는 상태로 설정합니다.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                // '/signup' 및 '/signin' 경로에 대한 요청은 모두 인증 없이 허용됩니다.
                        .antMatchers("/**/signup", "/**/signin").permitAll()
                .and()
                // 사용자 정의 인증 필터를 UsernamePasswordAuthenticationFilter 이전에 추가합니다.
                    .addFilterBefore(this.authenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/h2-console/**");
    }

    // spring boot 2.x
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
