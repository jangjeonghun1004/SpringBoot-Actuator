package com.example.demo.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> content = new HashMap<>();

        content.put("code-info", "정보 추가");
        builder.withDetail("custom-info-contributor", content);
    }
}
