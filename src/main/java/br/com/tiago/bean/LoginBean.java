package br.com.tiago.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.tiago.dao.PessoaDAO;
import br.com.tiago.model.Pessoa;
import br.com.tiago.util.SessionUtils;

@RequestScoped
@ManagedBean(name = "loginBean")
public class LoginBean  {
	
	@ManagedProperty(value = PessoaBean.INJETAR_NOME)
	private PessoaBean pessoaBean;
	
	
	public PessoaBean getPessoaBean() {
		return pessoaBean;
	}


	public void setPessoaBean(PessoaBean pessoaBean) {
		this.pessoaBean = pessoaBean;
	}
	private String email;
	private String senha;
	

	private Pessoa ehValidoLogin(String email, String senha) {
		
		Pessoa user = new PessoaDAO().procurarEmailSenha(email, senha);
		
		if (user == null || !senha.equals(user.getSenha())) {
			return null;
		}
		
		return user;		
	}
	
	
	public String entar() {
		Pessoa user = ehValidoLogin(email, senha);
		
		if (user != null) {
			pessoaBean.setUser(user);
			SessionUtils.getSession().setAttribute("user", user);
			return "Index";
		}
		pessoaBean.addMensangem("Email/senha Inválido!", FacesMessage.SEVERITY_WARN);
		return "Login";
	}
	
	
	
	
	
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
