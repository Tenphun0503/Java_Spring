/**
 * SpringConfig.java
 * Author: Ten Phun
 */
package speed.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("speed")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
}
