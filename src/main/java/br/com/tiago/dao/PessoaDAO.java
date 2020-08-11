package br.com.tiago.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.tiago.model.Pessoa;
import br.com.tiago.util.ErroSistema;
import br.com.tiago.util.JPAUtil;

public class PessoaDAO implements CrudIDAO<Pessoa> {

	private EntityManager manager;
	private EntityTransaction transaction;
	

	@Override
	public void salvar(Pessoa pessoa) {
		this.manager = JPAUtil.getEntityManager();
		this.transaction = this.manager.getTransaction();
		this.transaction.begin();

		this.manager.merge(pessoa);

		this.transaction.commit();
		this.manager.close();

	}

	
	public boolean findEmail(Pessoa pessoa) {
		
		this.manager = JPAUtil.getEntityManager();
		this.transaction = this.manager.getTransaction();
		this.transaction.begin();


		try {
			
			Pessoa emailPessoa = this.manager.createNamedQuery("findEmail", Pessoa.class).
					setParameter("email", pessoa.getEmail()).getSingleResult();
			
			if (emailPessoa.getEmail().equals(pessoa.getEmail())) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public void deletar(Pessoa pessoa) {
		this.manager = JPAUtil.getEntityManager();
		this.transaction = this.manager.getTransaction();
		this.transaction.begin();

		 Object id = JPAUtil.getPKey(pessoa);

		 this.manager.createQuery("delete from " + pessoa.getClass().getName() + 
		 " where id = " + id).executeUpdate();
		 
		this.transaction.commit();
		this.manager.close();
		
	}


	@Override
	public List<Pessoa> buscar() throws ErroSistema {
		this.manager = JPAUtil.getEntityManager();
		this.transaction = this.manager.getTransaction();
		this.transaction.begin();

		List<Pessoa> list = this.manager.createQuery("SELECT c FROM Pessoa c", Pessoa.class).getResultList();

		this.transaction.commit();
		this.manager.close();

		return list;
	}

}
