package br.com.tiago.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.tiago.model.Pessoa;
import br.com.tiago.util.JPAUtil;

public class PessoaDAO implements PessoaIDAO {

	private EntityManager manager;
	private EntityTransaction transaction;
	
	@Override
	public void salvar(Pessoa pessoa) {
		
		this.manager = JPAUtil.getEntityManager();
		this.transaction = this.manager.getTransaction();
		this.transaction.begin();
		this.manager.persist(pessoa);
		this.transaction.commit();
		this.manager.close();
		
	}

	@Override
	public void excluir(Pessoa pessoa) {
		
		
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		
		
	}

	@Override
	public List<Pessoa> listar() {

		return null;
	}

	@Override
	public Pessoa buscar(Long id) {

		return null;
	}
	
}
