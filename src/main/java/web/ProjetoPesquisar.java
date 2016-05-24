package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/projeto/pesquisar")
public class ProjetoPesquisar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO ="/projeto/formPesquisar.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.getRequestDispatcher(DESTINO).forward(request, response);
	} 

}
