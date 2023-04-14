/**
 * SpringMvcConfig.java
 * Created on Apr 04, 2023, 1:14 AM
 * Author: Ten Phun
 */
package ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"ssm.controller", "ssm.config"})
@EnableWebMvc
public class SpringMvcConfig {

}
