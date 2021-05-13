package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.*;

@Entity
public class Telefone implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "DDD", length = 2, nullable = false)
	private int ddd;
	
	@Column(name = "NUMERO", length = 9, nullable = false)
	private String numero;
	
	@Column(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;
		
	public Telefone() {
		// TODO Auto-generated constructor stub
	}
	
	public Telefone(int ddd, String numero, Usuario usuario) {
		this.ddd = ddd;
		this.numero = numero;
		this.usuario = usuario;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getDdd() {
		return ddd;
	}
	
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		String telefone;
		telefone = String.valueOf(this.ddd);
		telefone += this.numero;
		return telefone;
	}
}
