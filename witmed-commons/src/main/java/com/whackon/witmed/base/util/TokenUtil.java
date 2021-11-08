package com.whackon.witmed.base.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>系统 Token 工具类</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
public class TokenUtil {
    // 设置加密 Token 所使用的算法
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(BaseConstants.SECRET_KEY);

    /**
     * <b>根据用户所给定信息和过期时间创建 Token</b>
     * @param infoMap
     * @param expireTimeSec
     * @return
     */
    public static String createToken(Map<String, Object> infoMap, Long expireTimeSec) {
        // 创建生成 Token 的对象
        JWTCreator.Builder builder = JWT.create();
        // 对于一个完整的 Token 包括三部分：
        // 1、头部信息，包含：算法和相关信息
        Map<String, Object> header = new HashMap<String, Object>();
        // 设置信息为 JWT 所生成的 Token
        header.put("typ", "jwt");
        // 设置加密锁使用的算法为 HS256
        header.put("alg", "HS256");
        // 将头部信息设定到 Token 中
        builder.withHeader(header);
        // 2、有效载荷，可以将相关信息保存到 Token，在校验解密时，可以获得该信息
        // 将用户的主键增加到有效载荷中
        // 循环用户所给定的 Map 集合，将其中的数据进行设定
        // 获得所有的 key，变成 Set 集合
        builder.withClaim("info", infoMap);
        // 设定过期时间
        builder.withExpiresAt(new Date(new Date().getTime() + expireTimeSec * 1000));
        return builder.sign(ALGORITHM);
    }

    /**
     * <b>验证并解析 Token</b>
     * @param token
     * @return
     */
    public static Map<String, Object> verifyToken(String token) {
        // 校验此时所给定的 Token 是符合相关形式的
        if (token != null && !"".equals(token.trim())) {
            // 此时 Token 格式有效
            // 获得 Token 校验对象 JWTVerifier
            JWTVerifier verifier = JWT.require(ALGORITHM).build();
            // 对于该 Token 进行校验
            DecodedJWT decodedJWT = verifier.verify(token);
            // 如果能够获得 DecodedJWT 则说明通过秘钥能够将加密 Token 进行解密
            // 提取绑定在 Token 中的有效载荷信息
            Map<String, Object> params = decodedJWT.getClaim("message").asMap();
            return params;
        }
        return null;
    }
}
