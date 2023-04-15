/**
 * SpringMvcConfig.java
 * Created on Apr 14, 2023, 11:12 PM
 * Author: Ten Phun
 */
package inter.config;

import inter.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"inter.controller", "inter.config"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    private ProjectInterceptor pj;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pj).addPathPatterns("/books", "/books/*");
    }
}
