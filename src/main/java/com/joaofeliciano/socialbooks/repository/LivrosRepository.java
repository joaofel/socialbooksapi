package com.joaofeliciano.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaofeliciano.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

}
