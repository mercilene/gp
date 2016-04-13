package dao;

import java.util.List;

import dominio.Requisito;

public interface RequisitoDao {
	
 public void inserirAtualizar(Requisito x);
 public void excluir(Requisito x);
 public Requisito buscar(int cod);
 public List<Requisito> buscarTodos();
}
