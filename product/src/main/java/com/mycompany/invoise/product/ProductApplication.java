package com.mycompany.invoise.product;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@EntityScan("com.mycompany.invoise.core.entity.product")
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	public Hibernate5Module dataTypeHibernate5Module(){
		Hibernate5Module module= new Hibernate5Module();
		module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
		return module;
	}
}