package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.FuncionarioDao;
import dominio.Funcionario;

public class FuncionarioDaoImpl implements FuncionarioDao {
	
	private EntityManager em;
	
	public FuncionarioDaoImpl(){
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Funcionario x) {
		if (x.getCodFuncionario() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Funcionario x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Funcionario buscar(int cod) {
		return em.find(Funcionario.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> buscarTodos() {
		String jpql = "SELECT x FROM Funcionario x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Funcionario x ORDER BY x.nome";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Funcionario buscaCpfExato(String cpf) {
		String jpql = "SELECT x FROM Funcionario x WHERE x.cpf = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", cpf);
		List<Funcionario> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
}
