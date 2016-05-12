package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Funcionario;
import servico.FuncionarioServico;


@WebServlet("/funcionario/editar")
public class FuncionarioEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO ="/funcionario/formEditar.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		FuncionarioServico fs = new FuncionarioServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Funcionario func = fs.buscar(cod);
		request.setAttribute("item", func);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	} 

}
