package org.zerock.api01.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Log4j2
public class JWTUtilTests {

    @Autowired
    private JWTUtil jwtUtil;

    @Test
    public void testGenerate() {
        Map<String, Object> claimMap = Map.of("mid","ABCDE");
        String jwtStr = jwtUtil.generateToken(claimMap,1);
        log.info(jwtStr);
    }

    @Test
    public void testIsExpired() {

        //유효시간이 지난 토큰
        String jwtStr = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtaWQiOiJBQkNERSIsImlhdCI6MTcyMTAyMjE1NSwiZXhwIjoxNzIxMDIyMjE1fQ.2qlzNlckyFwCjjeeNF6IER9cOcTD1dilp6tBAEra2S4";
        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);
        log.info(claim);

    }

    @Test
    public void isInvalidJwtToken() {

        //문자열의 마지막 부분에 임의의 문자를 추가
        String jwtStr = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtaWQiOiJBQkNERSIsImlhdCI6MTcyMTAyMjE1NSwiZXhwIjoxNzIxMDIyMjE1fQ.2qlzNlckyFwCjjeeNF6IER9cOcTD1dilp6tBAEra2S4-";
        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);
        log.info(claim);

    }

    @Test
    public void testAll() {

        String jwtStr = jwtUtil.generateToken(Map.of("mid","AAAA","email","aaaa@bbb.com"),1);

        log.info(jwtStr);

        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);

        log.info("MID: " + claim.get("mid"));

        log.info("EMAIL: " + claim.get("email"));

    }



}