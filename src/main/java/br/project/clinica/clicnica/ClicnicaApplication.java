package br.project.clinica.clicnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.project.clinica.model")
@ComponentScan(basePackages = {"br.project.clinica.controller", "br.project.clinica.service"})
@EnableJpaRepositories("br.project.clinica.repository")
public class ClicnicaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ClicnicaApplication.class, args);
	}
}
