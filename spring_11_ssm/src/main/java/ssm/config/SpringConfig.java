/**
 * SpringConfig.java
 * Created on Apr 04, 2023, 1:05 AM
 * Author: Ten Phun
 */
package ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"ssm.service", "ssm.dao"})
@PropertySource("jdbc.properties")
@Import({MybatisConfig.class, JdbcConfig.class})
public class SpringConfig {
}
