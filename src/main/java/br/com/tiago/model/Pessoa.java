package br.com.tiago.model;

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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "findEmail", query = "Select p from Pessoa p where p.email = :email")
@NamedQuery(name = "Pessoa.findByEmailSenha", 
query = "Select p from Pessoa p where p.email = :email AND p.senha = :senha")
public abstract class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 5691619982422661889L;
	
	//@Transient
	//public static final String FIND_BY_EMAIL_SENHA = "Pessoa.findByEmailSenha";
	
	@Id
	@SequenceGenerator(initialValue = 1, allocationSize = 1,name = "generator_pessoa_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String senha;
	private boolean isAdmin;
	@Column(unique = true)
	private String email;	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "pessoa", targetEntity = Telefone.class)
	private List<Telefone> telefones = new ArrayList<Telefone>();
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "pessoa")
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	
	public boolean checkSenha(String senha) {
		
		if (this.senha.equals(senha)) {
			return true;
		}
		
		return false;
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
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", senha=" + senha + ", isAdmin=" + isAdmin + ", email=" + email
				+ ", telefones=" + telefones + ", enderecos=" + enderecos + "]";
	}
	
	
	

		
	
}
