package com.dourado.os.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dourado.os.domain.OS;
@Repository
public interface OSRepository extends JpaRepository<OS, Integer> {

}
