/**
 * SpringMvcSupport.java
 * Created on Apr 14, 2023, 11:33 PM
 * Author: Ten Phun
 */
package inter.config;

import inter.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    /*@Autowired
    private ProjectInterceptor pj;*/

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

    /* Let's move this into SpringMvcConfig
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pj).addPathPatterns("/books", "/books/*");
    }*/
}
