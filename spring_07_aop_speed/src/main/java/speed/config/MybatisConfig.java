/**
 * MybatisConfig.java
 * Author: Ten Phun
 */
package speed.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;


public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setTypeAliasesPackage("speed.domain");
        sessionFactory.setDataSource(dataSource);
        return sessionFactory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("speed.dao");
        return mapperScannerConfigurer;
    }
}
