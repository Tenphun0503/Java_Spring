/**
 * SpringConfig.java
 * Author: Ten Phun
 */
package mybatis.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("mybatis")
@PropertySource("classpath:jdbc.properties")
@Import({MybatisConfig.class, JdbcConfig.class})
public class SpringConfig {
}
