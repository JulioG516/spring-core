package com.in28minutes.learnspringframework.examples.g1;

import com.in28minutes.learnspringframework.exercises.businesscalculation.DataService1;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Named
class BusinessService {
	private DataService dataService;

	public DataService getDataService() {
		return dataService;
	}

//	@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter injection");
		this.dataService = dataService;
	}
}
@Named
class DataService {

}

@Configuration
@ComponentScan				// Localiza o @Component do pacman
public class JakartaCDIContextLauncherApplication {
	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext
					(JakartaCDIContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);


		}
	}
}
