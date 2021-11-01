package com.example.javaspring.filter;

import com.example.javaspring.JWT.JWTUtil;
import com.example.javaspring.service.AuthUserService.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        if (!request.getRequestURI().contains("/authenticate")){
            final String authorizationHeader = request.getHeader("Authorization");
            String jwt = null;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
            } else {
                response.setStatus(403);
            }
            SecurityContextHolder.getContext();
            Object details = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (SecurityContextHolder.getContext().getAuthentication() == null ||
                    !jwtUtil.validateToken(jwt,
                            (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
                response.setStatus(403);
            }
        }
        chain.doFilter(request, response);
    }
}

