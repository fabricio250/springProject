package br.com.season.springproject.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import br.com.season.springproject.config.SpringProjectConfig;
import br.com.season.springproject.service.HelloWorldService;
import br.com.season.springproject.service.HelloWorldServiceImpl;
import br.com.season.springproject.service.SchoolService;
import br.com.season.springproject.service.UserService;

public class SpringProjectMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringProjectConfig.class);

		HelloWorldService hello = context.getBean(HelloWorldService.class);
		hello.sayHello("Fabricio");
		hello.sayHello("Leticia");
		hello.sayHello("Joana");
		if (hello instanceof HelloWorldServiceImpl){
			System.out.println("-----------------------------");
			System.out.println("O nome da pessoa é: " + ((HelloWorldServiceImpl)hello).getUser());
			System.out.println("-----------------------------");
		}

		UserService user = context.getBean(UserService.class);
//		user.cadastrar();

		SchoolService school = context.getBean(SchoolService.class);
		school.estudar();

		context.close();




	}

}
