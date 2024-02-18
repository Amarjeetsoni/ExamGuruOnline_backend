package com.ExamGuruOnline.configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Service;

import com.ExamGuruOnline.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServices {

	
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;	
	private String secret="amarsoni";	
	
	
	//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}	
	
	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
    //for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}	
	
	
	//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}	
	
	
	//generate token for user to differentiate roles
	public String generateToken(User userDetails) {
		Map<String, Object> claims = new HashMap<>();
		if(userDetails!=null)
		{
			claims.put("role", userDetails.getUserRole());
			claims.put("emailId", userDetails.getEmail());
		}
		System.out.println("generate token");
		return doGenerateToken(claims, userDetails.getEmail());
	}	
	
	
	//Token Creation
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		System.out.println("dogenerate token");
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}	
	
	//validate token
	public Boolean validateToken(String token, User userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getEmail()) && !isTokenExpired(token));
	}	
}
