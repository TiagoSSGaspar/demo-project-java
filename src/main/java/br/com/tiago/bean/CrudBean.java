package br.com.tiago.bean;

import java.util.List;
import java.util.logging.Level;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sun.istack.internal.logging.Logger;

import br.com.tiago.dao.CrudIDAO;
import br.com.tiago.util.ErroSistema;

@SuppressWarnings("rawtypes")
public abstract class CrudBean<E, D extends CrudIDAO> {

	private String estadoTela = "buscar";

	private E entidade;
	private List<E> listaEntidades;
	private String confirmarSenha;

	public void novo() throws ErroSistema {
		this.entidade = criarNovaEntidade();
		mudarParaInserir();
	}

	@SuppressWarnings("unchecked")
	public void salvar() throws ErroSistema {
		try {

			if (getDao().findEmail(entidade)) {
				addMensangem("Email já foi cadastrado!", FacesMessage.SEVERITY_WARN);
			} else {

				getDao().salvar(entidade);
				entidade = criarNovaEntidade();
				addMensangem("Salvo com sucesso!", FacesMessage.SEVERITY_INFO);
				mudarParaBuscar();
			}



		} catch (ErroSistema e) {
			Logger.getLogger(e.getClass()).log(Level.SEVERE, null, e);
			addMensangem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}

	}

	public void editar(E entidade) {
		this.entidade = entidade;
		mudarParaEditar();
		listaEntidades.remove(entidade);
	}

	@SuppressWarnings("unchecked")
	public void deletar(E entidade) {
		try {
			getDao().deletar(entidade);
			addMensangem("Deletado com sucesso!", FacesMessage.SEVERITY_INFO);
			this.buscar();
		} catch (ErroSistema e) {
			Logger.getLogger(e.getClass()).log(Level.SEVERE, null, e);
			addMensangem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}

	@SuppressWarnings("unchecked")
	public void buscar() {

		if (isBusca() == false) {
			mudarParaBuscar();
			return;
		}

		try {
			listaEntidades = getDao().buscar();
			if (listaEntidades == null || listaEntidades.size() <= 0) {
				addMensangem("Não temos nada cadastrado!", FacesMessage.SEVERITY_WARN);
			}
		} catch (ErroSistema e) {
			Logger.getLogger(e.getClass()).log(Level.SEVERE, null, e);
			addMensangem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}

	public void addMensangem(String msg, FacesMessage.Severity tipoErro) {

		FacesMessage messagem = new FacesMessage(tipoErro, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, messagem);

	}

	public abstract D getDao();

	public abstract E criarNovaEntidade();

	public boolean isInseri() {
		return "inserir".equals(estadoTela);
	}

	public boolean isEdita() {
		return "editar".equals(estadoTela);
	}

	public boolean isBusca() {
		return "buscar".equals(estadoTela);
	}

	public void mudarParaInserir() {
		estadoTela = "inserir";
	}

	public void mudarParaEditar() {
		estadoTela = "editar";
	}

	public void mudarParaBuscar() {
		estadoTela = "buscar";
	}

	public E getEntidade() {
		return entidade;
	}

	public List<E> getListaEntidades() {
		return listaEntidades;
	}

	public void setEntidade(E entidade) {
		this.entidade = entidade;
	}

	public void setListaEntidades(List<E> listaEntidades) {
		this.listaEntidades = listaEntidades;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

}
