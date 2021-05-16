package edu.guet.report.api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author XUAN
 * @date 2021/5/16 - 1:34
 * @references
 * @purpose
 * @errors
 */
public class NotifyFromReportToUserMail {

    //常量
    public static final long EXPIRE = 1000 * 60 * 60 * 24; //token过期时间
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO"; //秘钥

    //生成token字符串的方法
    public static String getJwtToken(String uid, String train, Date departureTime){

        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                .setSubject("covid-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))

                .claim("uid", uid)  //设置token主体部分 ，存储用户信息
                .claim("train", train)
                .claim("departureTime", String.valueOf(departureTime.getTime()))
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if(jwtToken == null || "".equals(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param jwtToken
     * @return
     */
    public static String getUserId(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("uid");
    }

    /**
     * @param jwtToken
     * @return
     */
    public static String getTrain(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("train");
    }

    /**
     * @param jwtToken
     * @return
     */
    public static Date getDepartureTime(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return new Date(Long.parseLong((String) claims.get("departureTime")));
    }


}
