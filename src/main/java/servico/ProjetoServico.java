package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ProjetoDao;
import dao.impl.EM;
import dominio.Projeto;

public class ProjetoServico {
	
	private ProjetoDao dao;
	
	public ProjetoServico(){
		dao = DaoFactory.criarProjetoDao();
	}
	
	public void inserirAtualizar(Projeto x){
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	
	}
	
	 public void excluir(Projeto x){
		 EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	 }
	 
	 public Projeto buscar(int cod){
		 return  dao.buscar(cod);
	 }
	 
	 public List<Projeto> buscarTodos(){
		 return dao.buscarTodos();		 
	 }
}
