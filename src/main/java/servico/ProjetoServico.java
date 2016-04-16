package servico;

import java.util.Date;
import java.util.List;

import dao.DaoFactory;
import dao.ProjetoDao;
import dao.Transaction;
import dominio.Projeto;

public class ProjetoServico {
	
	private ProjetoDao dao;
	
	public ProjetoServico(){
		dao = DaoFactory.criarProjetoDao();
	}
	
	public void inserirAtualizar(Projeto x){
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
	
	
	 public void excluir(Projeto x){
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
		
	 
	 public Projeto buscar(int cod){
		 return  dao.buscar(cod);
	 }
	 
	 public List<Projeto> buscarTodos(){
		 return dao.buscarTodos();		 
	 }
	 
	 public List<Projeto> buscarPorNomeData( String nome, Date dataMin, Date dataMax){
		 return dao.buscarPorNomeData( nome, dataMin, dataMax);
	 }
}
