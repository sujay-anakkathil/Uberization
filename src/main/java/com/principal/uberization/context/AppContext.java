package com.principal.uberization.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan("com.principal.uberization")
@SpringBootApplication
public class AppContext {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AppContext.class, args);
	}

	/*
	 * @Bean public CommandLineRunner commandLineRunner(ApplicationContext ctx)
	 * { return args -> {
	 * 
	 * System.out.println("Let's inspect the beans provided by Spring Boot:");
	 * 
	 * String[] beanNames = ctx.getBeanDefinitionNames();
	 * Arrays.sort(beanNames); for (String beanName : beanNames) {
	 * System.out.println(beanName); }
	 * 
	 * }; }
	 */

}
