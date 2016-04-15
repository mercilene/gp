package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.TarefaDao;
import dominio.Tarefa;

public class TarefaDaoImpl implements TarefaDao {
	
	private EntityManager em;
	
	public TarefaDaoImpl(){
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Tarefa x) {
		if (x.getCodTarefa() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Tarefa x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Tarefa buscar(int cod) {
		return em.find(Tarefa.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarefa> buscarTodos() {
		String jpql = "SELECT x FROM Tarefa x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
