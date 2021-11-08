package com.dourado.os.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dourado.os.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbService;

	@Bean // método vai ser chamado,sempre que a classe for chamada
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
}
