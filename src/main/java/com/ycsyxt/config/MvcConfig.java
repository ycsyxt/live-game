package com.ycsyxt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yuxt
 * @date 2021/5/9
 * @description 允许跨域配置
 */
@Configuration
public class MvcConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry)
            {
                // 设置允许跨域的路径
                registry.addMapping("/**");
            }
        };
    }
}