package com.eventosapp.eventosapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class EventosappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventosappApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}


}
