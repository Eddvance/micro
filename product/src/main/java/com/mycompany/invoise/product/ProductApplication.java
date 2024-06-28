package com.mycompany.invoise.product;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EntityScan("com.mycompany.invoise.core.entity.product")
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	public Hibernate6Module dataTypeHibernate6Module(){
		Hibernate6Module module= new Hibernate6Module();
		module.disable(Hibernate6Module.Feature.USE_TRANSIENT_ANNOTATION);
		module.enable(Hibernate6Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
		return module;
	}

	@Bean
	public RestTemplate getRestTemplate(){return new RestTemplate();}
}