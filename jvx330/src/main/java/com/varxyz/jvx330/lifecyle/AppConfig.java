package com.varxyz.jvx330.lifecyle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.varxyz.jvx330.lifecyle.example1.Dog;
import com.varxyz.jvx330.lifecyle.example2.Eagle;
import com.varxyz.jvx330.lifecyle.example3.Goat;
import com.varxyz.jvx330.lifecyle.example3.Horse;

@Configuration
public class AppConfig {
	@Bean
	public Dog dog() {
		Dog d = new Dog("플루토");
		d.setName("볼트");
		return d;
	}
	@Bean (initMethod = "attachWings", destroyMethod = "detachWings")
	public Eagle eagle() {
		Eagle e = new Eagle();
		e.setName("에디");
		return e;
	}
	
	@Bean
	@Scope("singleton")
	public Goat goat() {
		return new Goat();
	}
	
	@Bean
	@Scope("prototype")
	public Horse horse() {
		return new Horse();
	}
}
