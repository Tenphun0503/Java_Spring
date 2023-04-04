/**
 * SpringConfig.java
 * Created on Apr 02, 2023, 10:18 PM
 * Author: Ten Phun
 */
package demo.config;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// Load Spring Servlet setting
/*public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    // Loading SpringMVC container setting
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    // Loading Spring container setting
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringConfig.class);
        return ctx;
    }

    // Setting which request belongs to SpringMVC
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}*/

// Or you can use this way to register servlet setting
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}