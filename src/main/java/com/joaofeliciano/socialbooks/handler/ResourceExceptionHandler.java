package com.joaofeliciano.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.joaofeliciano.socialbooks.domain.DetalhesErro;
import com.joaofeliciano.socialbooks.services.exceptions.AutorExistenteException;
import com.joaofeliciano.socialbooks.services.exceptions.AutorNotFoundException;
import com.joaofeliciano.socialbooks.services.exceptions.LivroNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(LivroNotFoundException.class)
	public ResponseEntity<DetalhesErro> handleLivroNotFound(LivroNotFoundException e,
													HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTimestamp(System.currentTimeMillis());
		erro.setTitulo("O livro não pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalhesErro> handleAutorExistente(AutorExistenteException e,
													HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTimestamp(System.currentTimeMillis());
		erro.setTitulo("Autor já existente.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(AutorNotFoundException.class)
	public ResponseEntity<DetalhesErro> handleAutorNotFound(AutorNotFoundException e,
													HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTimestamp(System.currentTimeMillis());
		erro.setTitulo("O autor não pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolation(DataIntegrityViolationException e,
													HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTimestamp(System.currentTimeMillis());
		erro.setTitulo("Requisição inválida.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
