package br.com.tiago.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends PessoaFisica implements Serializable {
	
	private static final long serialVersionUID = 7772469146611362333L;
	
	
	private String cnpj;
	private String inscricaoEstadual;
	private String razaoSocial;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	
}
