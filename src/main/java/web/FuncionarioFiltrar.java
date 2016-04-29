package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Funcionario;
import servico.FuncionarioServico;


@WebServlet("/funcionario/filtrar")
public class FuncionarioFiltrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO ="/funcionario/listar.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		FuncionarioServico fs = new FuncionarioServico();
		String nome = request.getParameter("busca");
		List<Funcionario> itens = fs.buscarPorNome(nome);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	} 

}
