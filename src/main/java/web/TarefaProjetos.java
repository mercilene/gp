package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Projeto;
import servico.ProjetoServico;


@WebServlet("/tarefa/projetos")
public class TarefaProjetos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO ="/tarefa/listarProjetos.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ProjetoServico ps = new ProjetoServico();
		List<Projeto> itens = ps.buscarTodos();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	} 

}
