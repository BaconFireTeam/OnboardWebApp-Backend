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

import com.baconfire.onboardwebapp.security.services.MyUserDetailsService;
import com.baconfire.onboardwebapp.security.util.JwtUtil;

//@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private MyUserDetailsService userDetailsService;

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
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			// TODO:
			// we still need this userDetails for authorization?
			// we need to get userDetails back from the authentication server and store
			// here?
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

			if (jwtUtil.validateToken(jwt, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// TODO:
				// question: this will help pass the following filter, which is
				// UsernamePasswordAuthenticationFilter.class?
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		} else {
			// if the user is not authenticated redirect to the authentication server
			String authService = this.getFilterConfig().getInitParameter("services.auth");
			response.sendRedirect(authService + "?redirect=" + request.getRequestURL());
			// TODO:
			// I need to redirect to the authentication server and get a response with jwt
			// back.
			// How do I get the jwt back?
			// Or I don't need to get the jwt back here. I could send a response form the
			// authentication server controller?
		}
		// pass on to next filter
		chain.doFilter(request, response);
	}
}
