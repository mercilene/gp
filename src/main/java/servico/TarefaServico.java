package servico;

import java.util.List;

import dao.DaoFactory;
import dao.TarefaDao;
import dao.impl.EM;
import dominio.Tarefa;

public class TarefaServico {
	
	private TarefaDao dao;
	
	public TarefaServico(){
		dao = DaoFactory.criarTarefaDao();
	}
	
	public void inserirAtualizar(Tarefa x){
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	
	}
	
	 public void excluir(Tarefa x){
		 EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	 }
	 
	 public Tarefa buscar(int cod){
		 return  dao.buscar(cod);
	 }
	 
	 public List<Tarefa> buscarTodos(){
		 return dao.buscarTodos();		 
	 }
}
