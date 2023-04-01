/**
 * SpringConfig.java
 * Created on Mar 31, 2023, 12:02 AM
 * Author: Ten Phun
 */
package annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// if we want to include multiple packages, we can use{p1, p2...}
@Configuration
@ComponentScan("annotation")
@PropertySource("book.properties")
public class SpringConfig {
}
