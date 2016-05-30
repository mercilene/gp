package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Funcionario;
import dominio.Projeto;
import dominio.Tarefa;
import servico.FuncionarioServico;
import servico.ProjetoServico;
import servico.RequisitoServico;
import servico.ServicoException;
import servico.TarefaServico;
import servico.ValidacaoException;


@WebServlet("/tarefa/inserir")
public class TarefaInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO ="//detalheCompleto.jsp";
	private static String FORM = "/tarefa/formInserir.jsp";
	private static String ERRO = "/public/erro.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProjetoServico ps = new ProjetoServico();
		RequisitoServico rs = new RequisitoServico();
		TarefaServico ts = new TarefaServico();
		FuncionarioServico fs = new FuncionarioServico();
		
		Tarefa x = Instanciar.tarefa(request);
		try {
			ts.validar(x);
			ts.inserir(x);
			Projeto projeto = ps.buscar(x.getProjeto).getCodProjeto());
			//projeto.getTarefa().size();
			request.setAttribute("item", projeto);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) {
			List<Funcionario> itens = fs.buscarTodos();
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.setAttribute("funcionarios", funcionarios);
			request.setAttribute("funcionariosSelecionados", x.getFuncionario());
			request.getRequestDispatcher(FORM).forward(request, response);
			
			
			<-- comentar List<Funcionario> itens = fs.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) {
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.getRequestDispatcher(FORM).forward(request, response);-->
		}
	
	} 

}
