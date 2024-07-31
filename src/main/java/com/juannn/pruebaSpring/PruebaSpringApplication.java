package com.juannn.pruebaSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaSpringApplication {

	private static Logger logger = LoggerFactory.getLogger(PruebaSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PruebaSpringApplication.class, args);
		logger.info("Proyecto iniciado");
		logger.debug("Mi mensaje debug");
                
		}

	}