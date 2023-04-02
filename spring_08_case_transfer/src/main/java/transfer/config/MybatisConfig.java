/**
 * MybatisConfig.java
 * Author: Ten Phun
 */
package transfer.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean factoryBean(DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setTypeAliasesPackage("transfer.domain");
        factoryBean.setDataSource(dataSource);
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer msc(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("transfer.dao");
        return msc;
    }
}
