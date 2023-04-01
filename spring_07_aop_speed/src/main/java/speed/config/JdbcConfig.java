/**
 * JdbcConfig.java
 * Author: Ten Phun
 */
package speed.config;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("$jdbc.username}")
    private String username;
    @Value("$jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setURL(url);
        dataSource.setUser(username);
        dataSource.setPassword((password));
        return dataSource;
    }
}
