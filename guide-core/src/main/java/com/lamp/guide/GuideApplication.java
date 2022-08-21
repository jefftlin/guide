package com.lamp.guide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author junfeng.lin
 * @date 2022/1/2 14:02
 */
@SpringBootApplication
@EnableCaching
public class GuideApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class, args);
    }
}
