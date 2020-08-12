package br.com.tiago.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tiago.dao.PessoaDAO;
import br.com.tiago.model.Pessoa;
import br.com.tiago.model.PessoaFisica;
import br.com.tiago.model.PessoaJuridica;
import br.com.tiago.util.SessionUtils;

@ManagedBean(name = "pessoaBean")
@SessionScoped
public class PessoaBean extends CrudBean<Pessoa, PessoaDAO> implements Serializable  {

	private static final long serialVersionUID = -7014495115804296554L;
	public static final String INJETAR_NOME = "#{pessoaBean}";
	
	private Pessoa pessoa;
	private PessoaDAO pessoaDAO;
	private boolean isPj;

	
	@Override
	public PessoaDAO getDao() { 
		if (pessoaDAO == null) {
			pessoaDAO = new PessoaDAO();
		}
		return pessoaDAO;
	}

	
	@Override
	public Pessoa criarNovaEntidade() {
		
		if (isPj) {
			return new PessoaJuridica();
		} else {
			return new PessoaFisica();
		}	
		
	}
	
	
	public boolean isAdmin() {
		return (pessoa.isAdmin()== true)? true: false;
	}
	
	public boolean isUserPadrao() {
		return false;
	}
	
	
	public String logOut() {
		SessionUtils.getSession().invalidate();
		return "Login";
	}
	
		
	public boolean isPj() {
		return isPj;
	}

	public void setPj(boolean isPj) {
		this.isPj = isPj;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	

}
