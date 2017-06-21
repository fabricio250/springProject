package br.com.season.springproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("br.com.season.springproject") 
public class SpringProjectConfig extends WebMvcConfigurerAdapter{ //WebMvcConfigurerAdapter serve para usar o tiles. Assim deixa de usar o @Bean

	@Bean
	public TilesConfigurer tilesConfigure(){
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
		tiles.setCheckRefresh(true);
		return tiles;
	}
	
	@Override //Se o comanando estiver errado, o @Override acusa
	public void configureViewResolvers(ViewResolverRegistry registry){
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/static/**").addResourceLocations("/static");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(3155692);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(3155692);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(3155692);
		
	}
	
//	@Bean
//	public ViewResolver viewResolver(){
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/views/pages/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
//	
//	@Bean(name="helloBean")
//	@Description("Description")
//	public  HelloWorldService hello(){
//		return new HelloWorldServiceImpl();
//	}
	
//	@Bean
//	public UserService user(){
//		return new UserServiceImpl();
//	}
	
//	@Bean
//	public SchoolService school(){
//		return new SchoolServiceImpl();
//	}
}
