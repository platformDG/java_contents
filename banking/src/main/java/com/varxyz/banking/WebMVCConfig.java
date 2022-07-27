package com.varxyz.banking;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc 			//스프링 MVC 설정에 대한 기본 구성 제공
@ComponentScan( basePackages = "com.varxyz.banking" )
public class WebMVCConfig implements WebMvcConfigurer {
	
	/**
	 * DispatcherServlet의 매핑 경로를 "/"로 주었을 때, JSP/HTML/CSS 등을 바르게 처리하도록 한다.
	 * <mvc:default-servlet-handler>
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configer) {
		configer.enable();
	}
	
	/**
	 * 컨트롤러의 처리 결과를 jsp로 표시하기 위한 설정
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	/**
	 * src/main/webapp//resources 위치의 정적 리소스를 설정
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
	
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
	
}
