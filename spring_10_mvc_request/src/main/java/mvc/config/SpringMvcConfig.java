/**
 * SpringMvcConfig.java
 * Created on Apr 03, 2023, 9:18 PM
 * Author: Ten Phun
 */
package mvc.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("mvc.controller")
@EnableWebMvc
public class SpringMvcConfig {
}
