package com.in28minutes.learnspringframework.exercises.businesscalculation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan				// Localiza o @Component do pacman
public class BussinesCalculationContextLauncherApplication {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext
					(BussinesCalculationContextLauncherApplication.class)) {

			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
	}
}
