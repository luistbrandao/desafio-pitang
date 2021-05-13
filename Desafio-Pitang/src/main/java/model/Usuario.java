package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.*;


@Entity
public class Usuario implements Serializable {

	/**
	 * A estrutura do usuário

	• Nome [string]

	• Email [string]

	• Senha[string]

	• Telefones [lista] o ddd [número] o Número [string] o Tipo [string]
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "EMAIL", length = 20, nullable = false)
	private String email;
	
	@Column(name = "SENHA", length = 4, nullable = false)
	private String senha;
	
	@OneToMany(mappedBy = "USUARIO", cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Usuario(String email, String nome, String senha, List<Telefone> telefones) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefones = telefones;
	}
    
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	public List<Telefone> getTelefones() {
		return telefones;
	}
	
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
}
