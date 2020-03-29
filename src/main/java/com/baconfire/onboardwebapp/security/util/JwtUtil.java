//package com.baconfire.onboardwebapp.security.util;
//
//import java.util.Date;
//import java.util.function.Function;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Service;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//
//@Service
//public class JwtUtil {
//
//	// TODO:
//	// this key should be somehow obtained from the authentication server
//	private String SECRET_KEY = "CORGCORG";
//
//	public static String getSubject(HttpServletRequest httpServletRequest, String jwtTokenCookieName,
//			String signingKey) {
//		String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
//		if (token == null)
//			return null;
//		return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody().getSubject();
//	}
//
//	public String extractUsername(String token) {
//		return extractClaim(token, Claims::getSubject);
//	}
//
//	public Date extractExpiration(String token) {
//		return extractClaim(token, Claims::getExpiration);
//	}
//
//	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//		final Claims claims = extractAllClaims(token);
//		return claimsResolver.apply(claims);
//	}
//
//	private Claims extractAllClaims(String token) {
//		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
//	}
//
//	private Boolean isTokenExpired(String token) {
//		return extractExpiration(token).before(new Date());
//	}
//
//	public Boolean validateToken(String token) {
//		return (!isTokenExpired(token));
//	}
//}
