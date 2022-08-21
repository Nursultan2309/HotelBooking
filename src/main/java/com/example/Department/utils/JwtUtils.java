package com.example.Department.utils;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
//
//    public final static Long TOKEN_EXPIRATION = 300000L;
//    public final static String SECRET_KEY = "privet";
//
//    public String generateToken(Authentication authentication) {
//        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
//        return Jwts.builder()
//                .setSubject(userPrincipal.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(new Date().getTime() + TOKEN_EXPIRATION))
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                .compact();
//    }
//
//    public String getUserNameFromJwtToken(String token) {
//        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public boolean validateJwtToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
//            return true;
//        } catch (SignatureException e) {
//            logger.error("Не правильно был передан ключ {}" + e.getMessage());
//        } catch (MalformedJwtException e) {
//            logger.error("Неправильно сам Token {} " + e.getMessage());
//        } catch (ExpiredJwtException e) {
//            logger.error("Прошло время  {}" + e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            logger.error("Не поддерживается {}" + e.getMessage());
//        }
//        catch (IllegalArgumentException e) {
//            logger.error("Стаки или подчерк написан не верно {} " + e.getMessage());
//        }
//        return false;
//    }
}
