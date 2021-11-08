package com.dourado.os.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dourado.os.domain.Tecnico;
//Classe  e Repositorio que você quer passar
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    

}
