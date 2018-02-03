package br.com.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.webapi.filter.TokenFilter;


@SpringBootApplication
public class WebApiApplication {
	
	@Bean
	public FilterRegistrationBean getFiltroJwt(){
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new TokenFilter());
		filter.addUrlPatterns("/admin/*");
		
		return filter;
	}

	public static void main(String[] args) {
		SpringApplication.run(WebApiApplication.class, args);
	}
}
