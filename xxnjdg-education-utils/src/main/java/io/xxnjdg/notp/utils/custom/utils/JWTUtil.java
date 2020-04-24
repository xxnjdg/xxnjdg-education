package io.xxnjdg.notp.utils.custom.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-24 上午1:22
 */
public class JWTUtil {

    private static final String TOKEN_SECRET = "eyJhbGciOiJIUzI1NiJ9";
    private static final String ISSUER = "RONCOO";
    public static final String USER_NO = "userNo";

    /**
     * 30
     */
    public static final Long DATE = 30 * 60 * 1000L;

    public static String create(Long userNo,Long date){
        return JWT.create()
                .withIssuer(ISSUER)
                .withClaim(USER_NO,userNo.toString())
                .withExpiresAt(new Date(System.currentTimeMillis()+date))
                .sign(Algorithm.HMAC256(TOKEN_SECRET));
    }

    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(TOKEN_SECRET))
                .withIssuer(ISSUER)
                .build()
                .verify(token);
    }

}
