package com.in28minutes.learnspringframework.examples.a1;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBussinessClass {
													// @Autowired -  Field Injection
	Dependency1 dependency1;

	Dependency2 dependency2;

	@Autowired 								// Não precisa de anotação Autowired
	public YourBussinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		System.out.println("Constructor Injection");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}

//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {			// Setter Injection
//		System.out.println("Setter injection - setDependency1");
//		this.dependency2 = dependency2;
//	}
}

@Component
class Dependency1 {

}
@Component
class Dependency2{

}

@Configuration
@ComponentScan				// Localiza o @Component do pacman
public class DependecyInjectionLauncherApplication {





	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext
					(DependecyInjectionLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);

			System.out.println(context.getBean(YourBussinessClass.class));

		}
	}
}
