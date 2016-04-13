package servico;

import java.util.List;

import dao.DaoFactory;
import dao.FuncionarioDao;
import dao.impl.EM;
import dominio.Funcionario;

public class FuncionarioServico {
	
	private FuncionarioDao dao;
	
	public FuncionarioServico(){
		dao = DaoFactory.criarFuncionarioDao();
	}
	
	public void inserirAtualizar(Funcionario x){
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	
	}
	
	 public void excluir(Funcionario x){
		 EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	 }
	 
	 public Funcionario buscar(int cod){
		 return  dao.buscar(cod);
	 }
	 
	 public List<Funcionario> buscarTodos(){
		 return dao.buscarTodos();		 
	 }
}
