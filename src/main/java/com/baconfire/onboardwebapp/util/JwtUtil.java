//package com.baconfire.onboardwebapp.util;
//
//import com.baconfire.onboardwebapp.domain.common.MyUserDetails;
//import com.google.gson.Gson;
//import io.jsonwebtoken.*;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//
//
//@Service
//public class JwtUtil {
//
//	@Value("${security.jwt.token.secret-key:secret}")
//	private String secretKey = "secret";
//
//	public Authentication getAuthentication(String token) {
//		String UserDetailString = getUserDetail(token);
//		Gson gson = new Gson();
//
//		UserDetails userDetails = gson.fromJson(UserDetailString, MyUserDetails.class);
//
//		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//	}
//
//	public String getUserDetail(String token) {
//		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
//	}
//
//	public String resolveToken(HttpServletRequest req) {
//		String bearerToken = req.getHeader("Authorization");
//		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//			return bearerToken.substring(7);
//		}
//		return null;
//	}
//
//	public boolean validateToken(String token) {
//		try {
//			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//
//			if (claims.getBody().getExpiration().before(new Date())) {
//				return false;
//			}
//
//			return true;
//		} catch (JwtException | IllegalArgumentException e) {
//			return false;
//		}
//	}
//}
