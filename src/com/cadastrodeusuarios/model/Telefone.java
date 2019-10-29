package com.cadastrodeusuarios.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Telefone implements Serializable {

	@Column(nullable = true)
	private Integer ddd;
	
	@Column(nullable = true)
	private String numero;
	
	@Column(nullable = true)
	private String tipo;
	
	
	
	
	public String completo() {
		return "( " + ddd + " )" + " " + numero + ", " + " Tipo: " + tipo;
	}
	
	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
