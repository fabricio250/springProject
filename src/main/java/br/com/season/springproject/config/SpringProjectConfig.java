package br.com.season.springproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.season.springproject.service.HelloWorldService;
import br.com.season.springproject.service.HelloWorldServiceImpl;
import br.com.season.springproject.service.SchoolService;
import br.com.season.springproject.service.SchoolServiceImpl;
import br.com.season.springproject.service.UserService;
import br.com.season.springproject.service.UserServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan("br.com.season.springproject")
public class SpringProjectConfig {
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean(name="helloBean")
	@Description("Description")
	public  HelloWorldService hello(){
		return new HelloWorldServiceImpl();
	}
	
//	@Bean
//	public UserService user(){
//		return new UserServiceImpl();
//	}
	
	@Bean
	public SchoolService school(){
		return new SchoolServiceImpl();
	}
}
