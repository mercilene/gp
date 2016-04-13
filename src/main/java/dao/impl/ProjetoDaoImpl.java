package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ProjetoDao;
import dominio.Projeto;

public class ProjetoDaoImpl implements ProjetoDao {
	
	private EntityManager em;
	
	public ProjetoDaoImpl(){
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Projeto x) {
		if (x.getCodProjeto() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Projeto x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Projeto buscar(int cod) {
		return em.find(Projeto.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Projeto> buscarTodos() {
		String jpql = "SELECT x FROM Projeto x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
