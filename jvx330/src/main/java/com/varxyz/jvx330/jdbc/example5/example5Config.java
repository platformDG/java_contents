package com.varxyz.jvx330.jdbc.example5;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
@ComponentScan(basePackages = "com.varxyz.jvx330.jdbc.example5")
public class example5Config {
	
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
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dateSource());
	}
	
	@Bean
	public AccountDao accountDao() {
		return new AccountDao(dateSource());
	}
}
