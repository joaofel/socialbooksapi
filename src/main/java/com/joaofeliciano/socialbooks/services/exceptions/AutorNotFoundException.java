package com.joaofeliciano.socialbooks.services.exceptions;

public class AutorNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AutorNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public AutorNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
