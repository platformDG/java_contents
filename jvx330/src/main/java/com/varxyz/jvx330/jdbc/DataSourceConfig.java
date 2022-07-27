package com.varxyz.jvx330.jdbc;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.jvx330.jdbc.example1.AddCustomerDao;
import com.varxyz.jvx330.jdbc.example1.AddCustomerDataSourceDao;
import com.varxyz.jvx330.jdbc.example2.CustomerDao;

@Configuration
public class DataSourceConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dateSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jvx330?serverTimezone=Asia/Seoul");
		ds.setUsername("jvx330");
		ds.setPassword("jvx330");
		
		//커넥션 pool과 관련된 작업
		ds.setInitialSize(2);	// 커넥션 풀 초기화시 생성할 초기 커넥션 갯수 (기본값은 10)
		ds.setMaxActive(10);	// 풀에서 가져올 수 있는 최대 커넥션 갯수 ( 기본값 100 )
		ds.setMaxIdle(10);		// 풀에 유지할수 있는 최대 커넥션 갯수 ( 기본값 MaxActive와 동일 ) 
		return ds;
	}
	
	@Bean
	public AddCustomerDataSourceDao addCustomerDataSourceDao() {
		return new AddCustomerDataSourceDao(dateSource());
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dateSource());
	}
	
	@Bean
	public AddCustomerDao addCustomerDao() {
		return new AddCustomerDao(dateSource());
	}
	
	@Bean
	public CustomerDao customerDao() {
		return new CustomerDao(dateSource());
	}
}
