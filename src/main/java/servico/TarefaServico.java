package servico;

import java.util.List;

import dao.DaoFactory;
import dao.TarefaDao;
import dao.Transaction;
import dominio.Tarefa;

public class TarefaServico {
	
	private TarefaDao dao;
	
	public TarefaServico(){
		dao = DaoFactory.criarTarefaDao();
	}
	
	public void inserirAtualizar(Tarefa x){
		try{
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
			}
			catch (RuntimeException e) {
				if (Transaction.isActive()){
					Transaction.rollback();
				}
				System.out.println("Erro: "+ e.getMessage());
			}
			
		}
	
	
	 public void excluir(Tarefa x){
		 try{
				Transaction.begin();
				dao.inserirAtualizar(x);
				Transaction.commit();
				}
				catch (RuntimeException e) {
					if (Transaction.isActive()){
						Transaction.rollback();
					}
					System.out.println("Erro: "+ e.getMessage());
				}
				
			}
		
	 
	 public Tarefa buscar(int cod){
		 return  dao.buscar(cod);
	 }
	 
	 public List<Tarefa> buscarTodos(){
		 return dao.buscarTodos();		 
	 }
}
