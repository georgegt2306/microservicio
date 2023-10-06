package com.datos.personales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MsDatosPersonalesApplication { //extends SpringBootServletInitializer

	public static void main(String[] args) {
		SpringApplication.run(MsDatosPersonalesApplication.class, args);
	}
	
    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MsDatosPersonalesApplication.class);
    }*/

}
