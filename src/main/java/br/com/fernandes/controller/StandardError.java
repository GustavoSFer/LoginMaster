package br.com.fernandes.controller;

import java.time.Instant;

public class StandardError {
	
	private String mensagem;
	private Instant instant;
	
	public StandardError() {}

	public StandardError(String mensagem, Instant instant) {
		this.mensagem = mensagem;
		this.instant = instant;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	};
}
