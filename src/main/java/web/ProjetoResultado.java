package web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Projeto;
import servico.ProjetoServico;


@WebServlet("/projeto/resultado")
public class ProjetoResultado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO ="/projeto/resultadoBusca.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ProjetoServico ps = new ProjetoServico();
		String nome = request.getParameter("nome");
		date dataMin = Date.parse(request.getParameter("dataMin"));
		date dataMax = Date.parse(request.getParameter("dataMax"));
		List<Projeto> itens = ps.buscarPorNomeData(nome, dataMin, dataMax);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	} 

}
