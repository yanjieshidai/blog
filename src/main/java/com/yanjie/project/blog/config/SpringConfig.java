package com.yanjie.project.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by wangjie12 on 15-7-6.
 */

@Configuration
@ImportResource({"classpath:spring-mvc.xml", "classpath:spring-jdbc.xml"})
public class SpringConfig {
}
