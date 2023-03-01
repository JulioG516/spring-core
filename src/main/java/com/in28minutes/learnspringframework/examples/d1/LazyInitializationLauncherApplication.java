package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}

@Component
@Lazy
class ClassB{
	private ClassA classA;
	public ClassB(ClassA classA) {
		System.out.println("\n\nSome initialization logic\n\n");
		this.classA = classA;
	}

	public void doSomething() {
		System.out.println("Do something in here");
	}
}

@Configuration
@ComponentScan				// Localiza o @Component do pacman
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext
					(LazyInitializationLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);

			System.out.println("Initialization of context is completed");

			context.getBean(ClassB.class).doSomething();

		}
	}
}
