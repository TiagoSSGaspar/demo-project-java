package br.com.tiago.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.tiago.model.Endereco;
import br.com.tiago.model.PessoaJuridica;
import br.com.tiago.model.Telefone;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = -7014495115804296554L;

	// private PessoaFisica pessoa = new PessoaFisica();
	private PessoaJuridica pessoa = new PessoaJuridica();
	private Endereco endereco = new Endereco();
	private Telefone telefone = new Telefone();
	private boolean ehPj;
	private String confirmarSenha;
	private List<Endereco> listaEnderecos = new ArrayList<Endereco>();
	List<Telefone> listaTelefones = new ArrayList<Telefone>();
	private String nomesEstados[] = { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
			"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará",
			"Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
			"Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" };

	public String salvar() {

		listaEnderecos.add(endereco);
		pessoa.setEnderecos(listaEnderecos);
		listaTelefones.add(telefone);

		return "";
	}

	public void addEndereco() {
		listaEnderecos.add(endereco);
	}

	public void addTelefone() {
		listaTelefones.add(telefone);
	}

	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public PessoaJuridica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaJuridica pessoa) {
		this.pessoa = pessoa;
	}

	public String[] getNomesEstados() {
		return nomesEstados;
	}

	public void setNomesEstados(String nomesEstados[]) {
		this.nomesEstados = nomesEstados;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isEhPj() {
		return ehPj;
	}

	public void setEhPj(boolean ehPj) {
		this.ehPj = ehPj;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

}
