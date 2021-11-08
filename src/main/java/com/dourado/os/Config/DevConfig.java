package com.dourado.os.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dourado.os.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
@Autowired
private DBService dbService;
@Value("${spring.jpa.hibernate.ddl-auto}")
private String ddl;

    @Bean // método vai ser chamado,sempre que a classe for chamada
	public boolean instanciaDB() {
	if(ddl.equals("create")) {
	 this.dbService.instanciaDB();
	}
	return false;
	}
}
