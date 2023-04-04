/**
 * MybaitsConfig.java
 * Created on Apr 04, 2023, 1:14 AM
 * Author: Ten Phun
 */
package ssm.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean factoryBean(DataSource ds){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setTypeAliasesPackage("ssm.domain");
        return factoryBean;
    }


    @Bean
    public MapperScannerConfigurer msc(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("ssm.dao");
        return msc;
    }
}
