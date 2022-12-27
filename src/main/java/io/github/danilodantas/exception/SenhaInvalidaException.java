package io.github.danilodantas.exception;

public class SenhaInvalidaException extends RuntimeException {
	public SenhaInvalidaException() {
		super("Senha inválida.");
		
	}
}
