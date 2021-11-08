package com.dourado.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dourado.os.Repositories.ClienteRepository;
import com.dourado.os.Repositories.OSRepository;
import com.dourado.os.Repositories.TecnicoRepository;
import com.dourado.os.domain.Cliente;
import com.dourado.os.domain.OS;
import com.dourado.os.domain.Tecnico;
import com.dourado.os.domain.enuns.Prioridade;
import com.dourado.os.domain.enuns.Status;

@Service
public class DBService {
	@Autowired // Criando uma instancia dos repository,só que quem vai gerenciar isso vai ser o
	// spring boot
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Gustavo", "429.556.920-85", "(11)98888-8888");
		Tecnico t2 = new Tecnico(null, "Dourado", "178.201.740-21", "(11)98788-8858");
		Cliente c1 = new Cliente(null, "Betina campos", "534.737.970-73", "(11)98585-9685");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OD", Status.ANDAMENTO, t1, c1);
		t1.getList().add(os1);
		c1.getList().add(os1);
		tecnicoRepository.saveAll(Arrays.asList(t1,t2)); // podemos salvar uma lista de instancia de tecnico
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));

	}
}
