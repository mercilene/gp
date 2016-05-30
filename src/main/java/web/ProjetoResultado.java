package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	private static String DESTINO = "/projeto/resultadoBusca.jsp";
	private static String ERRO = "/public/erro.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			ProjetoServico ps = new ProjetoServico();
			String nome = request.getParameter("nome");

			Date dataMin = sdf.parse(request.getParameter("dataMin"));
			Date dataMax = sdf.parse(request.getParameter("dataMax"));

			List<Projeto> itens = ps.buscarPorNomeData(nome, dataMin, dataMax);
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ParseException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);

		}
	}

}
