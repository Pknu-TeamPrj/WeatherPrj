package com.teamprj.weatherprj.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.teamprj.weatherprj.service.CustomOauth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOauth2UserService customOatuh2UserService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http://localhost:8080/** 권한을 주겠다 */
        // 다 접근 가능(게시판 보기 가능) 글쓰기는 로그인을 해야 한다.
        // http.authorizeHttpRequests((atr) -> atr.requestMatchers(new AntPathRequestMatcher("/**"))
        //         .permitAll())
                // 로그인, 회원가입 페이지만 로그인하지 않고도 접근 가능
                // http.authorizeHttpRequests((atr) -> atr.requestMatchers(new
                // AntPathRequestMatcher("/member/register"),new
                // AntPathRequestMatcher("/member/login"))
                // CSRF 위변조 공격을 막는 부분 해제, 특정 URL은 csrf 공격 리스트에서 제거
                // CORS 타서버간 접근 권한
                // .cors(corsConfig -> corsConfig.configurationSource(corsConfigurationSource()))
                // // REST API 전달시 403 Error 발생
                // .csrf((csrf) -> csrf.disable())
                // // h2-console 페이지가 frameset, frame으로 구성 CORS와 유사한 옵션추가
                // .headers((headers) -> headers
                //         .addHeaderWriter(new XFrameOptionsHeaderWriter(
                //                 XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN // ignoringRequestMatchers 영역에 있는
                //                                                                        // 프레임이니까 해제해줘.
                //         )));
                // // 로그인 url을 지정
                // .formLogin((fl) -> fl.loginPage("/member/login")
                //         .defaultSuccessUrl("/"))
                // // 로그아웃 처리
                // .logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                //         .logoutSuccessUrl("/")
                //         .invalidateHttpSession(true));
        
        // 인덱스 파일에만 접근할 수 있으며 나머지 모든 것은 접근할 수 없습니다.
        http.authorizeHttpRequests((auth) -> auth.requestMatchers(new AntPathRequestMatcher("/js/**"), new AntPathRequestMatcher("/css/**"),new AntPathRequestMatcher("/images/**")).permitAll()
                                    .anyRequest().authenticated()
                                    )
                                    .oauth2Login((auth) -> auth
                                        .loginPage("/")
                                        .userInfoEndpoint(userInfo -> userInfo.userService(customOatuh2UserService))
                                        .defaultSuccessUrl("/memberReg")
                                        .failureUrl("/")
                                        .permitAll())
                                        .csrf(crsf -> crsf.disable())
                                        .headers((headers) ->
                                        headers.addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
                                // 로그아웃
                                    .logout((logout) -> logout     //로그아웃 설정 시작 부분
                                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))     //로그아웃 처리할 url 패턴 지정
                                    .logoutSuccessUrl("/")       //로그아웃 성공적으로 된후 다른 페이지로 보낼 url
                                    .invalidateHttpSession(true)    //로그아웃 시 사용자의 세션을 무효화 할지 여부 지정
                                    .deleteCookies("JSESSIONID"));     //로그아웃시 삭제할 쿠키 지정 ("JSESSIONID" 쿠키를 삭제하여 세션과 관련된 모든 정보 삭제)

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.setAllowCredentials(true);
            return config;
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
