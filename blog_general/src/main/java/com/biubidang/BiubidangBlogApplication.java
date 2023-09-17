package com.biubidang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan ("com.biubidang.Mapper")
@EnableScheduling
@EnableSwagger2
@EnableWebMvc
public class BiubidangBlogApplication {
    public static void main(String[] args){
        SpringApplication.run(BiubidangBlogApplication.class,args);
    }

}
