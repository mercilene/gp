package dao;

import java.util.List;

import dominio.Tarefa;

public interface TarefaDao {
	
 public void inserirAtualizar(Tarefa x);
 public void excluir(Tarefa x);
 public Tarefa buscar(int cod);
 public List<Tarefa> buscarTodos();
}
