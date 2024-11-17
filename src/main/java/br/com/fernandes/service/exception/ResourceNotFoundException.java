package br.com.fernandes.service.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Usuário com o id: " + id + ", não encontrado!");
	}
}
