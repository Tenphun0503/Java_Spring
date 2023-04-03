/**
 * SpringConfig.java
 * Created on Apr 02, 2023, 10:18 PM
 * Author: Ten Phun
 */
package demo.config;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// Load Spring Servlet setting
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    // Loading SpringMVC container setting
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    // Setting which request belongs to SpringMVC
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    // Loading Spring container setting
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
