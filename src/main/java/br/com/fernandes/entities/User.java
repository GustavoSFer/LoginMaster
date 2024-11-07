package br.com.fernandes.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import br.com.fernandes.enums.StatusUser;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Date dataCriacao;
	private String celular;
	private String role;
	private StatusUser status;
	private Date dataNascimento;
	private String VerificacaoToken;
	private boolean isVerificado;

	public User() {}
	
	public User(String nome, String email, String senha, String celular, String role, Date dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
		this.role = role;
		this.dataNascimento = dataNascimento;
		this.dataCriacao = new Date();
		this.isVerificado = false;
		this.status = StatusUser.Bloqueado;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public StatusUser getStatus() {
		return status;
	}

	public void setStatus(StatusUser status) {
		this.status = status;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getVerificacaoToken() {
		return VerificacaoToken;
	}

	public void setVerificacaoToken(String verificacaoToken) {
		VerificacaoToken = verificacaoToken;
	}

	public boolean isVerificado() {
		return isVerificado;
	}

	public void setVerificado(boolean isVerificado) {
		this.isVerificado = isVerificado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
