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
import servico.ServicoException;


@WebServlet("/funcionario/inserir")
public class FuncionarioInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO ="/funcionario/listar.jsp";
	private static String ERRO ="/public/erro.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		FuncionarioServico fs = new FuncionarioServico();
		Funcionario x = Instanciar.funcionario(request);
		try {
			fs.inserir(x);
			List<Funcionario> itens = fs.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		}
	
	} 

}
