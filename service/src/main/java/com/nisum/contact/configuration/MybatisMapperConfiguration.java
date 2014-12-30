package com.nisum.contact.configuration;

import com.nisum.contact.repository.mapper.SellChannelDetailsMapper;
import com.nisum.contact.repository.mapper.TradeStoneDpoMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.gap.sourcing.order.repository.mapper")
public class MybatisMapperConfiguration {

    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean(name = "tradestoneDpoMapper")
    public TradeStoneDpoMapper tradestoneDpoMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<TradeStoneDpoMapper> bean = new
                MapperFactoryBean<TradeStoneDpoMapper>();
        bean.setMapperInterface(TradeStoneDpoMapper.class);
        bean.setSqlSessionFactory(sqlSessionFactory);
        return bean.getObject();
    }

    @Bean(name = "sellChannelDetailsMapper")
    public SellChannelDetailsMapper sellChannelDetailsMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<SellChannelDetailsMapper> bean = new MapperFactoryBean<SellChannelDetailsMapper>();
        bean.setMapperInterface(SellChannelDetailsMapper.class);
        bean.setSqlSessionFactory(sqlSessionFactory);
        return bean.getObject();
    }


}