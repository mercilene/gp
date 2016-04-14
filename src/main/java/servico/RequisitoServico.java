package servico;

import java.util.List;

import dao.DaoFactory;
import dao.RequisitoDao;
import dao.Transaction;
import dominio.Requisito;

public class RequisitoServico {
	
	private RequisitoDao dao;
	
	public RequisitoServico(){
		dao = DaoFactory.criarRequisitoDao();
	}
	
	public void inserirAtualizar(Requisito x){
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
	
	
	 public void excluir(Requisito x){
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
		
	 
	 public Requisito buscar(int cod){
		 return  dao.buscar(cod);
	 }
	 
	 public List<Requisito> buscarTodos(){
		 return dao.buscarTodos();		 
	 }
}
