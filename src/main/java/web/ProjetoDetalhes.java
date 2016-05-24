package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Projeto;
import servico.ProjetoServico;


@WebServlet("/projeto/detalhes")
public class ProjetoDetalhes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO ="/projeto/formPesquisar.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ProjetoServico ps = new ProjetoServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Projeto projeto = ps.buscar(cod);
		request.setAttribute("item", projeto);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	} 

}
