package com.joaofeliciano.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaofeliciano.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{
	
}
