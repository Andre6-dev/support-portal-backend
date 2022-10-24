package com.devandre.supportportalbackend.filter;

import com.devandre.supportportalbackend.constant.SecurityConstant;
import com.devandre.supportportalbackend.utility.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.devandre.supportportalbackend.constant.SecurityConstant.*;

/**
 * Authorize or not authorize any request
 *
 * @author Andre Gallegos
 * @create 2022-09-28 10:22
 **/
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private JWTTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilter(JWTTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Check if the request has a header with the token
        if (request.getMethod().equalsIgnoreCase(OPTIONS_HTTP_METHOD)) {
            response.setStatus(HttpStatus.OK.value());
        } else {
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader == null || !authorizationHeader.startsWith(TOKEN_PREFIX)) {
                // If the request doesn't have a header with the token, we don't authorize the request
                filterChain.doFilter(request, response);
                return;
            }
            // If the token is valid, then we will get token with Bearer
            String token = authorizationHeader.substring(TOKEN_PREFIX.length());
            // Get username from token
            String username = jwtTokenProvider.getSubject(token);
            // Verify if the token is valid
            if (jwtTokenProvider.isTokenValid(username, token) && SecurityContextHolder.getContext().getAuthentication() == null) {
                List<GrantedAuthority> authorities = jwtTokenProvider.getAuthorities(token);
                Authentication authentication = jwtTokenProvider.getAuthentication(username, authorities, request);
                // Set the authentication in the security context
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                // If the token is not valid, then we will throw an exception
                SecurityContextHolder.clearContext();
            }
        }
        filterChain.doFilter(request, response);
    }
}

