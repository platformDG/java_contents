package com.varxyz.jvx330.jdbc.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.varxyz.jvx330.jdbc.DataSourceConfig;

@Configuration
@Import(DataSourceConfig.class)

public class example1Config {
	
}
