package br.com.tiago.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 5633849810914540736L;
	
	@Column(length = 11,unique = true)
	private String cpf;
	@Column(length = 9)
	private String rg;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	
}
