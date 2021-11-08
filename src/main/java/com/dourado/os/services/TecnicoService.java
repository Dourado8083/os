package com.dourado.os.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.validation.Valid;

import com.dourado.os.Repositories.PessoaRepository;
import com.dourado.os.Repositories.TecnicoRepository;
import com.dourado.os.domain.Pessoa;
import com.dourado.os.domain.Tecnico;
import com.dourado.os.dtos.TecnicoDTO;
import com.dourado.os.services.exceptions.DataIntegratyViolationException;
import com.dourado.os.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository ;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + " Tipo: " + Tecnico.class.getName()));

	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		// Jeito 1
		// Tecnico newOBJ = new Tecnico(null, objDTO.getNome(), objDTO.getCpf(),
		// objDTO.getTelefone())
		// return repository.save(newOBJ);
		// Jeito 2
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		return repository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico oldOBJ = findById(id); // caso não exista,ele vai manda a exceção
		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		// Caso ele não entre em nenhuma dessa condições e salva
		oldOBJ.setNome(objDTO.getNome());
		oldOBJ.setCpf(objDTO.getCpf());
		oldOBJ.setTelefone(objDTO.getTelefone());
		return repository.save(oldOBJ);
	}

	public void delete(Integer id) {
		Tecnico obj = findById(id);
		// se for maior que 0, o tec possui serviço...
		if (obj.getList().size() > 0) {
			throw new DataIntegratyViolationException("Técnico possui Ordens de Serviço, não pode ser deletado!");
		}
	}

   
	private Pessoa findByCPF(TecnicoDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if (obj != null) {
			return obj;
		}
		return null;
	}

}
