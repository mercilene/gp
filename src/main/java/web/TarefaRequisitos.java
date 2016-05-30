package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Requisito;
import servico.RequisitoServico;


@WebServlet("/tarefa/requisitos")
public class TarefaRequisitos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO ="/tarefa/listarRequisitos.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		RequisitoServico rs = new RequisitoServico();
		List<Requisito> itens = rs.buscarTodos();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	} 

}
