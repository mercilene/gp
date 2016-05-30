package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Funcionario;
import dominio.Requisito;
import dominio.Tarefa;
import servico.FuncionarioServico;
import servico.RequisitoServico;


@WebServlet("/tarefa/nova")
public class TarefaNova extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO ="/tarefa/formInserir.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	RequisitoServico rs = new RequisitoServico();
	FuncionarioServico fs = new FuncionarioServico();
			
	int codRequisito = Integer.parseInt(request.getParameter("codRequisito"));
	Requisito requisito = rs.buscar(codRequisito);
	
	Tarefa nova = new Tarefa();
	nova.setRequisito(requisito);
		
	List<Funcionario> funcionarios = fs.buscarTodos();
	
        request.setAttribute("item", nova);	
		request.setAttribute("funcionarios", funcionarios);
		request.setAttribute("funcionarioSelecionado", null);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	} 

}
