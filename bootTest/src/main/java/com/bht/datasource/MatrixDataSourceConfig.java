package com.bht.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.bht.dao.matrixDao",sqlSessionFactoryRef = "matrixSqlSessionFactory")
public class MatrixDataSourceConfig {

    @Primary // @Primary的作用是  如果申明的bean名字相同，则注入有该注解的对象，否则抛出异常
    @Bean(name = "matrixDataSource")
    @ConfigurationProperties(prefix = "datasource.matrix")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "matrixSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("matrixDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/matrixMapper/*Mapper.xml"));
        return sessionFactoryBean.getObject();
    }
}
