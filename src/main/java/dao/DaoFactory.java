package dao;

import dao.impl.ClienteDaoImpl;
import dao.impl.FuncionarioDaoImpl;
import dao.impl.ProjetoDaoImpl;
import dao.impl.RequisitoDaoImpl;
import dao.impl.TarefaDaoImpl;

public class DaoFactory {
	
	public static FuncionarioDao criarFuncionarioDao(){
		return new FuncionarioDaoImpl();
	}
	
	public static ClienteDao criarClienteDao(){
		return new ClienteDaoImpl();
	}
	
	public static ProjetoDao criarProjetoDao(){
		return new ProjetoDaoImpl();
	}
	
	
	public static RequisitoDao criarRequisitoDao(){
		return new RequisitoDaoImpl();
	}
	
	public static TarefaDao criarTarefaDao(){
		return new TarefaDaoImpl();
	}

}
