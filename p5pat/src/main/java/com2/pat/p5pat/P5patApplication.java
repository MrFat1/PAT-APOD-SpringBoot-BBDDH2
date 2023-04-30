package com2.pat.p5pat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com2.pat.p5pat.controler","com2.pat.p5pat.domain","com2.pat.p5pat.services","com2.pat.p5pat.actuator"})
public class P5patApplication {

	private static Logger log = LoggerFactory.getLogger(P5patApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(P5patApplication.class, args);
		log.info("La aplicación ha iniciado correctamente.");
	}
}
