package dao.impl;

import java.util.Date;
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
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Projeto> buscarNomeData( String nome, Date dataMin, Date dataMax){
		String jpql = "SELECT x FROM Projeto x WHERE x.nome LIKE :p1 AND x.dataEntrega >= :p2 AND x.dataEntrega <= :p3";
		Query query = em.createQuery(jpql);
		query.setParameter("p1","%" +nome+ "%");
		query.setParameter("p2", dataMin);
		query.setParameter("p3", dataMax);
		return query.getResultList();
	}

}
