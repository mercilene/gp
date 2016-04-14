package servico;

import java.util.List;

import dao.DaoFactory;
import dao.FuncionarioDao;
import dao.Transaction;
import dominio.Funcionario;

public class FuncionarioServico {
	
	private FuncionarioDao dao;
	
	public FuncionarioServico(){
		dao = DaoFactory.criarFuncionarioDao();
	}
	
	public void inserirAtualizar(Funcionario x){
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
	
	
	 public void excluir(Funcionario x){
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
		
	 
	 public Funcionario buscar(int cod){
		 return  dao.buscar(cod);
	 }
	 
	 public List<Funcionario> buscarTodos(){
		 return dao.buscarTodos();		 
	 }
}
