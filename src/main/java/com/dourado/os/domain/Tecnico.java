package com.dourado.os.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Tecnico extends Pessoa implements Serializable {
private static final long serialVersionUID = 1L;
@JsonIgnore //Correção de Serialização 
@OneToMany(mappedBy = "tecnico") // 1tecnico para varios serviços 
private List<OS> list = new ArrayList<>();
public Tecnico() {
		super();
	
	}

	public Tecnico(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
		
	}

	public List<OS> getList() {
		return list;
	}

	public void setList(List<OS> list) {
		this.list = list;
	}

}
