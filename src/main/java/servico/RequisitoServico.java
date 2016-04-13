package servico;

import java.util.List;

import dao.DaoFactory;
import dao.RequisitoDao;
import dao.impl.EM;
import dominio.Requisito;

public class RequisitoServico {
	
	private RequisitoDao dao;
	
	public RequisitoServico(){
		dao = DaoFactory.criarRequisitoDao();
	}
	
	public void inserirAtualizar(Requisito x){
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	
	}
	
	 public void excluir(Requisito x){
		 EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	 }
	 
	 public Requisito buscar(int cod){
		 return  dao.buscar(cod);
	 }
	 
	 public List<Requisito> buscarTodos(){
		 return dao.buscarTodos();		 
	 }
}
