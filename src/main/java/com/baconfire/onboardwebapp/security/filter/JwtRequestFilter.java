
package com.baconfire.onboardwebapp.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.baconfire.onboardwebapp.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
		String token = jwtUtil.resolveToken(httpServletRequest);
		if (token != null && jwtUtil.validateToken(token)) {
			Authentication auth = jwtUtil.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		} else {
			httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
}
