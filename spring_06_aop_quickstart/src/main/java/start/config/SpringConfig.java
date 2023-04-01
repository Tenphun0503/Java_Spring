/**
 * SpringConfig.java
 * Author: Ten Phun
 */
package start.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("start")
@EnableAspectJAutoProxy
public class SpringConfig {
}
