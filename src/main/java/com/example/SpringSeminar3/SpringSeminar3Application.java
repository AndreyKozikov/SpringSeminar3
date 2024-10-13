package com.example.SpringSeminar3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
Создать сервис "RegistrationService", который принимает на вход данные о пользователе (имя, возраст, email),
создает пользователя с помощью UserService, затем использует DataProcessingService для добавления пользователя
в список и выполнения операций над этим списком. После выполнения каждой операции, использовать NotificationService
для вывода информации о выполненной операции.
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.example.SpringSeminar3")
public class SpringSeminar3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSeminar3Application.class, args);
	}

}
