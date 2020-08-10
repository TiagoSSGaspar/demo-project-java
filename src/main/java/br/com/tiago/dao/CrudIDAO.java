package br.com.tiago.dao;

import java.util.List;

import br.com.tiago.util.ErroSistema;

public interface CrudIDAO<E> {

	void salvar(E entidade) throws ErroSistema;

	void deletar(E entidade) throws ErroSistema;

	//void atualizar(E entidade) throws ErroSistema;

	List<E> buscar() throws ErroSistema;

	boolean findEmail(E entidade);
} 
