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
	
	public void inserir(Funcionario x) throws ServicoException{
		try{
			Funcionario aux = dao.buscaCpfExato(x.getCpf());
			if(aux != null){
				throw new ServicoException("Já existe um funcionário cadastrado com este CPF!", 1);
			}
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
	
	public void atualizar(Funcionario x) throws ServicoException{
		try{
			Funcionario aux = dao.buscaCpfExatoDiferente(x.getCodFuncionario(), x.getCpf());
			if(aux != null){
				throw new ServicoException("Já existe um funcionário cadastrado com este CPF!", 1);
			}
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
	
	
	 public void excluir(Funcionario x) throws ServicoException{
		 try{
			 x = dao.buscar(x.getCodFuncionario());
			 if(!x.getTarefas().isEmpty()){
				 throw new ServicoException("Exclusão não permitida: este funcionario possui tarefas", 2);
			 }
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
	 
	 public List<Funcionario> buscarTodosOrdenadosPorNome(){
		 return dao.buscarTodosOrdenadosPorNome();		 
	 }
	 
	 public List<Funcionario> buscarPorNome(String trecho){
		 return dao.buscarPorNome(trecho);
	 }
}
