package com.joaofeliciano.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaofeliciano.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

}
