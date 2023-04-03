/**
 * SpringMvcConfig.java
 * Author: Ten Phun
 */
package demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// Load controller bean
@Configuration
@ComponentScan("demo.springmvc")
@Import(ServletContainersInitConfig.class)
public class SpringMvcConfig {
}
