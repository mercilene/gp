package dao;

import java.util.List;

import dominio.Funcionario;

public interface FuncionarioDao {
	
 public void inserirAtualizar(Funcionario x);
 public void excluir(Funcionario x);
 public Funcionario buscar(int cod);
 public List<Funcionario> buscarTodos();
 
 public List<Funcionario> buscarTodosOrdenadosPorNome();
 public Funcionario buscaCpfExato(String cpf);
}
