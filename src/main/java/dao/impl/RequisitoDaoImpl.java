package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.RequisitoDao;
import dominio.Requisito;

public class RequisitoDaoImpl implements RequisitoDao {
	
	private EntityManager em;
	
	public RequisitoDaoImpl(){
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Requisito x) {
		if (x.getCodRequisito() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Requisito x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Requisito buscar(int cod) {
		return em.find(Requisito.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Requisito> buscarTodos() {
		String jpql = "SELECT x FROM Requisito x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
