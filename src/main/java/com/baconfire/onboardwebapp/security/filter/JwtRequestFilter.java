<<<<<<< HEAD
package com.baconfire.onboardwebapp.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.baconfire.onboardwebapp.security.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization");

		String username = null;
		String jwt = null;

		// extract the username and token
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}

		// the second condition is used to make sure SecurityContextHolder doesn't
		// already have a authenticated user
		// if the user is authenticated
		if (username != null && jwtUtil.validateToken(jwt)) {
			chain.doFilter(request, response);
		} else {
			// if the user is not authenticated, send a 401 error response
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			// TODO:
			// response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
}
