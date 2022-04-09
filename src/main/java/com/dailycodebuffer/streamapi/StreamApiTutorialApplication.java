package com.dailycodebuffer.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dailycodebuffer.streamapi.model.Employee;

@SpringBootApplication
public class StreamApiTutorialApplication {

	static List<Employee> employees = new ArrayList<>();
	
	static {
		employees.add(
				new Employee("Dilma", "Opressora", 6000.0, List.of("Projeto 1", "Projeto 2", "Projeto 3"))
		);
		
		employees.add(
				new Employee("Gorete", "Medeiros", 3000.0, List.of("Projeto 1", "Projeto 2", "Projeto 3"))
		);
		
		employees.add(
				new Employee("Juvenal", "Tenório", 2500.0, List.of("Projeto 6", "Projeto 7", "Projeto 7"))
		);
	}

	public static void main(String[] args) {
		//SpringApplication.run(StreamApiTutorialApplication.class, args);
		employees.stream()
			.forEach(employee -> System.out.println(employee));
		
		//map
		//collect
		Set<Employee> increaseSalary 
		= employees.stream()
		.map(emp -> new Employee(
			emp.getFirstName(),
			emp.getLastName(),
			emp.getSalary() * 1.10,
			emp.getProjects()
		))
		.collect(Collectors.toSet());
		System.out.println(increaseSalary);
		
		//filter
		List<Employee> listEmp = employees
			.stream()
			.filter(emp -> emp.getSalary() > 5000.0)
			.map(emp -> new Employee(
				emp.getFirstName(),
				emp.getLastName(),
				emp.getSalary() * 1.10,
				emp.getProjects()
			))
			.collect(Collectors.toList());
		System.out.println(listEmp);
		
		
		System.out.println("-------------------------------------\n");
		//filter
				Employee firstEmp = employees
					.stream()
					.filter(emp -> emp.getSalary() > 7000.0)
					.map(emp -> new Employee(
						emp.getFirstName(),
						emp.getLastName(),
						emp.getSalary() * 1.10,
						emp.getProjects()
					))
					.findFirst()
					.orElse(null);
				
				
				System.out.println(firstEmp);
		
	}

}
