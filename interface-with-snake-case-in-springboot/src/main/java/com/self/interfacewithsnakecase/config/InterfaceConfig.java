package com.self.interfacewithsnakecase.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * 该配置类中增加了对蛇峰转驼峰以及驼峰转回蛇峰的配置
 * 从而能够达到提供给前端的接口中展示的是蛇峰的命名方式
 * 而参数传递到springMVC后会自动将蛇峰转换成对应的驼峰进行参数赋值
 */
@Configuration
public class InterfaceConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return new Jackson2ObjectMapperBuilderCustomizer() {

            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                jacksonObjectMapperBuilder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            }
        };
    }
}
