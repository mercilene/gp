package dao;

import java.util.List;

import dominio.Funcionario;
import dominio.Requisito;
import dominio.Tarefa;

public interface TarefaDao {
	
 public void inserir(Tarefa x);
 public void atualizar(Tarefa x);
 public void excluir(Tarefa x);
 public Tarefa buscar(int cod);
 public List<Tarefa> buscarTodos();
 public Tarefa buscarExato(String descricao, Integer horas, Funcionario funcionario, Requisito requisito);
 public Tarefa buscarExatoDiferente( Integer codigo, String descricao, Integer horas, Funcionario funcionario, Requisito requisito);
}
