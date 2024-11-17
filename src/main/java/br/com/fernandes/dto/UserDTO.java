package br.com.fernandes.dto;

import java.util.Date;

import br.com.fernandes.enums.RoleUser;
import br.com.fernandes.enums.StatusUser;

public class UserDTO {
		Long id;
		String nome;
		String email;
		Date dataCriacao;
		String celular;
		RoleUser role;
		Date dataNascimento;
		StatusUser status;
		boolean isVerificado;
		
		public UserDTO() {};
		
		public UserDTO(Long id, String nome, String email, Date dataCriacao, String celular, RoleUser role,
				Date dataNascimento, StatusUser status, boolean isVerificado) {
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.dataCriacao = dataCriacao;
			this.celular = celular;
			this.role = role;
			this.dataNascimento = dataNascimento;
			this.status = status;
			this.isVerificado = isVerificado;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getDataCriacao() {
			return dataCriacao;
		}

		public void setDataCriacao(Date dataCriacao) {
			this.dataCriacao = dataCriacao;
		}

		public String getCelular() {
			return celular;
		}

		public void setCelular(String celular) {
			this.celular = celular;
		}

		public RoleUser getRole() {
			return role;
		}

		public void setRole(RoleUser role) {
			this.role = role;
		}

		public Date getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public StatusUser getStatus() {
			return status;
		}

		public void setStatus(StatusUser status) {
			this.status = status;
		}

		public boolean isVerificado() {
			return isVerificado;
		}

		public void setVerificado(boolean isVerificado) {
			this.isVerificado = isVerificado;
		}
		

}
