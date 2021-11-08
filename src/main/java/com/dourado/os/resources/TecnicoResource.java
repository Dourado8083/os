package com.dourado.os.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dourado.os.domain.Tecnico;
import com.dourado.os.dtos.TecnicoDTO;
import com.dourado.os.services.TecnicoService;
@CrossOrigin("*")
//Resource são os controller
@RestController
//adicionando a anotação, pois estamos setando para acessar o recursos dos tecnico 
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {
	@Autowired
	private TecnicoService service;
	/*
	 * Pegando técnicos pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
		TecnicoDTO objDTO = new TecnicoDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	/*
	 * Pegando todos os técnicos
	 */

	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll() {

		List<TecnicoDTO> listDTO = service.findAll().stream().map(obj -> new TecnicoDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	/*
	 * Criando um Técnico.
	 */
	@PostMapping
	public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDTO){
		Tecnico newOBJ = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newOBJ.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	/*
	 *Atualizando dados do Técnico.
	 */
	
	@PutMapping(value = "/{id}")

	public ResponseEntity<TecnicoDTO>update(@PathVariable Integer id,@Valid @RequestBody TecnicoDTO objDTO){
	TecnicoDTO newOBJ = new TecnicoDTO(service.update(id,objDTO));	
	return ResponseEntity.ok().body(newOBJ);
	}
	/*
	 * Deletando o Técnico
	 */
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		service.delete(id);
	 return	ResponseEntity.noContent().build();
	}
} 
