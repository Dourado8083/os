package com.dourado.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dourado.os.Repositories.ClienteRepository;
import com.dourado.os.Repositories.PessoaRepository;
import com.dourado.os.domain.Cliente;
import com.dourado.os.domain.Pessoa;
import com.dourado.os.dtos.ClienteDTO;
import com.dourado.os.services.exceptions.DataIntegratyViolationException;
import com.dourado.os.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + " Tipo: " + Cliente.class.getName()));

	}
	public List<Cliente>findAll(){
	return repository.findAll();
	}
	
	public Cliente create(ClienteDTO objDTO) {
		Cliente newOBJ = new Cliente(null, objDTO.getNome(), objDTO.getCpf(),objDTO.getTelefone());
		 return repository.save(newOBJ);
	}
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
    Cliente oldOBJ = findById(id);
    if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
    throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");	
    }
    
    oldOBJ.setNome(objDTO.getNome());
    oldOBJ.setCpf(objDTO.getCpf());
    oldOBJ.setTelefone(objDTO.getTelefone());
    return repository.save(oldOBJ);
	}
	public void delete(Integer id) {
	Cliente obj = findById(id);
	if(obj.getList().size()> 0) {
		throw new DataIntegratyViolationException("O Pessoa Possui um atendimento em Aberto");	
	}
	repository.deleteById(id);
	}
	
	private Pessoa findByCPF(ClienteDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if (obj != null) {
			return obj;
		}
		return null;
	}

}
