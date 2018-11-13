package com.peter.bj.util.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.*;

/**
 * @author panxinbing
 *         create time:  2018/5/3.
 */
public class Jwt {

    /**
     * 利用jwt生成token信息.
     * @param claims 数据声明（Claim）其实就是一个Map，比如我们想放入用户名，
     *               可以简单的创建一个Map然后put进去
     * @param secret 用于进行签名的秘钥
     * @return
     */
    public static String generateToken(Map<String, Object> claims,String secret) {
        //设置过期时间为10分钟
        Date ecpiration = new Date(System.currentTimeMillis()+600000L);
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(ecpiration)
//                .signWith(SignatureAlgorithm.HS512, secret) //采用什么算法是可以自己选择的，不一定非要采用HS512
//                .compact();
        return null;
    }

    /**
     * 利用jwt解析token信息.
     * @param token 要解析的token信息
     * @param secret 用于进行签名的秘钥
     * @return
     */
    public static Optional<Claims> getClaimsFromToken(String token, String secret) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            return Optional.of(claims);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * 验证token是否过期
     * @param tooken 要解析的token信息
     * @param secret 用于进行签名的秘钥
     * @return
     */
    public static boolean isExpired(String tooken,String secret){
        Optional<Claims> claims= getClaimsFromToken(tooken,secret);
        if(claims.isPresent()){
            Date expiration = claims.get().getExpiration();
            return expiration.before(expiration);
        }
        return false;
    }

    /**
     * 获取tooken中的参数值
     * @param token 要解析的token信息
     * @param secret 用于进行签名的秘钥
     * @return
     */
    public static Map<String,Object> extractInfo(String token,String secret){
        Optional<Claims> claims = getClaimsFromToken(token,secret);
        if(claims.isPresent()){
            Map<String,Object> info = new HashMap<String,Object>();
            Set<String> keySet = claims.get().keySet();

            Iterator<String> iterator = keySet.iterator();
            while(iterator.hasNext()){
                String key = iterator.next();
                Object value =  claims.get().get(key);
                info.put(key,value);

            }
            return info;
        }
        return null;
    }
}
