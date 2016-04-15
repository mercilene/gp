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
	
	public void inserir(Tarefa x) throws ServicoException{
		try{
			Tarefa aux =dao.buscarExato(x.getDescricao(), x.getHoras(), x.getFuncionario(), x.getRequisito());
			if (aux != null){
				throw new ServicoException("Já existe essa mesma tarefa cadastrada para o"+ " funcionário " + x.getFuncionario().getNome() + " no requisito" + x.getRequisito().getDescricao(), 3);
			}
			Transaction.begin();
			dao.inserir(x);
			Transaction.commit();
			}
			catch (RuntimeException e) {
				if (Transaction.isActive()){
					Transaction.rollback();
				}
				System.out.println("Erro: "+ e.getMessage());
			}
	}
		public void atualizar(Tarefa x) throws ServicoException{
			try{
				Tarefa aux =dao.buscarExatoDiferente(x.getCodTarefa(),x.getDescricao(), x.getHoras(), x.getFuncionario(), x.getRequisito());
				if (aux != null){
					throw new ServicoException("Já existe essa mesma tarefa cadastrada para o"+ " funcionário " + x.getFuncionario().getNome() + " no requisito" + x.getRequisito().getDescricao(), 3);
				}
				Transaction.begin();
				dao.atualizar(x);
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
				dao.atualizar(x);
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
