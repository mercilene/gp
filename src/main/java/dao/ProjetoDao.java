package dao;

import java.util.List;

import dominio.Projeto;

public interface ProjetoDao {
	
 public void inserirAtualizar(Projeto x);
 public void excluir(Projeto x);
 public Projeto buscar(int cod);
 public List<Projeto> buscarTodos();
}
