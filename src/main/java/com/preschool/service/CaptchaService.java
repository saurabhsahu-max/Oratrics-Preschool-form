package com.preschool.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CaptchaService {

    @Value("${recaptcha.secret-key}")
    private String secretKey;

    public double verifyCaptcha(String token){

        String url = "https://www.google.com/recaptcha/api/siteverify";

        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("secret", secretKey);
        map.add("response", token);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(url,map,Map.class);

        Map body = response.getBody();
        
        System.out.println("Google Response: " + body);

        if(body == null) return 0.0;

        Boolean success = (Boolean) body.get("success");

        if(success == null || !success){
            return 0.0;
        }

        Object scoreObj = body.get("score");

        if(scoreObj instanceof Number){
            return ((Number) scoreObj).doubleValue();
        }

        return 0.0;
    }

}