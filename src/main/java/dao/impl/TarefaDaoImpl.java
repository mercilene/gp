package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.TarefaDao;
import dominio.Funcionario;
import dominio.Requisito;
import dominio.Tarefa;

public class TarefaDaoImpl implements TarefaDao {
	
	private EntityManager em;
	
	public TarefaDaoImpl(){
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserir(Tarefa x) {
		if (x.getCodTarefa() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void atualizar(Tarefa x) {
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Tarefa buscarExato(String descricao, Integer horas, Funcionario funcionario, Requisito requisito){
		String jpql = "SELECT x FROM Tarefa x WHERE x.descricao = :p1 AND  x.horas = :p2 AND x.funcionario = :p3 AND x.requisito = :p4";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", descricao);
		query.setParameter("p2", horas);
		query.setParameter("p3", funcionario);
		query.setParameter("p4", requisito);
		List<Tarefa> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Tarefa buscarExatoDiferente(Integer codigo, String descricao, Integer horas, Funcionario funcionario, Requisito requisito){
		String jpql = "SELECT x FROM Tarefa x WHERE x.codigoTarefa <> :p0 AND x.descricao = :p1 AND  x.horas = :p2 AND x.funcionario = :p3 AND x.requisito = :p4";
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codigo);
		query.setParameter("p1", descricao);
		query.setParameter("p2", horas);
		query.setParameter("p3", funcionario);
		query.setParameter("p4", requisito);
		List<Tarefa> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
}
