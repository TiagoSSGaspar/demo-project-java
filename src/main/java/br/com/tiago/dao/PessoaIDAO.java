package br.com.tiago.dao;

import java.util.List;

import br.com.tiago.model.Pessoa;

public interface PessoaIDAO {
	
	void salvar(Pessoa pessoa);
	void excluir(Pessoa pessoa);
	void atualizar(Pessoa pessoa);
	List<Pessoa> listar();
	Pessoa buscar(Long id);
}
