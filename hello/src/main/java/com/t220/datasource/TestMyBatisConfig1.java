//package com.t220.datasource;
//
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
//
//@Configuration
//// basePackages 最好分开配置 如果放在同一个文件夹可能会报错
//@MapperScan(basePackages = "com.t220.test01", sqlSessionTemplateRef = "testSqlSessionTemplate")
//public class TestMyBatisConfig1 {
//
//	// 配置数据源
//	@Primary
//	@Bean(name = "testDataSource")
//	public DataSource testDataSource(DBConfig1 testConfig) throws SQLException {
//		MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
//		mysqlXaDataSource.setUrl(testConfig.getUrl());
//		mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
//		mysqlXaDataSource.setPassword(testConfig.getPassword());
//		mysqlXaDataSource.setUser(testConfig.getUsername());
//		mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
//		//使用springboot+jta+atomikos 分布式事物管理
//		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
//		xaDataSource.setXaDataSource(mysqlXaDataSource);
//		xaDataSource.setUniqueResourceName("testDataSource");
//
//		xaDataSource.setMinPoolSize(testConfig.getMinPoolSize());
//		xaDataSource.setMaxPoolSize(testConfig.getMaxPoolSize());
//		xaDataSource.setMaxLifetime(testConfig.getMaxLifetime());
//		xaDataSource.setBorrowConnectionTimeout(testConfig.getBorrowConnectionTimeout());
//		xaDataSource.setLoginTimeout(testConfig.getLoginTimeout());
//		xaDataSource.setMaintenanceInterval(testConfig.getMaintenanceInterval());
//		xaDataSource.setMaxIdleTime(testConfig.getMaxIdleTime());
//		xaDataSource.setTestQuery(testConfig.getTestQuery());
//		return xaDataSource;
//	}
//
//	@Primary
//	@Bean(name = "testSqlSessionFactory")
//	public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource)
//			throws Exception {
//		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//		bean.setDataSource(dataSource);
//		return bean.getObject();
//	}
//
//	@Primary
//	@Bean(name = "testSqlSessionTemplate")
//	public SqlSessionTemplate testSqlSessionTemplate(
//			@Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//}