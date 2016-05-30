package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import dominio.Funcionario;
import dominio.Projeto;
import dominio.Requisito;
import dominio.Tarefa;
import servico.ClienteServico;
import servico.FuncionarioServico;
import servico.ProjetoServico;
import servico.RequisitoServico;

public class Instanciar {
public static Tarefa tarefa(HttpServletRequest request) {
		
		ClienteServico cs = new ClienteServico();
		ProjetoServico ps = new ProjetoServico();
		RequisitoServico rs = new RequisitoServico();
		FuncionarioServico fs = new FuncionarioServico();
		
		
		Tarefa aux = new Tarefa();
		String s;
		
		s = request.getParameter("codTarefa");
		if (s != null && !s.isEmpty()) {
			try{
			aux.setCodTarefa(Integer.parseInt(s));
			} catch(NumberFormatException e){
				System.out.println("Instanciacao: codTarefa inválido");
			}
		}

		s = request.getParameter("descricao");
		if (s != null && !s.isEmpty()) {
			aux.setDescricao(s);
		}

		s = request.getParameter("horas");
		if (s != null && !s.isEmpty()) {
		//	aux.setHoras(s);
		}
		
		s = request.getParameter("codFuncionario");
		if (s != null && !s.isEmpty()) {
			try{
				Funcionario x = fs.buscar(Integer.parseInt(s));
				aux.setFuncionario(x);
			} catch (NumberFormatException e){
				System.out.println("Instanciacao: codFuncionario invalido");
			}
	}
		
		s = request.getParameter("codRequisito");
		if (s != null && !s.isEmpty()) {
			try{
				Requisito x = rs.buscar(Integer.parseInt(s));
				aux.setRequisito(x);
			} catch (NumberFormatException e){
				System.out.println("Instanciacao: codRequisito invalido");
			}
	}
		
		s = request.getParameter("codProjeto");
		if (s != null && !s.isEmpty()) {
			try{
				Projeto x = ps.buscar(Integer.parseInt(s));
			//	aux.setProjeto(x);
			} catch (NumberFormatException e){
				System.out.println("Instanciacao: codProjeto invalido");
			}
	}

		return aux;
	}
	
	
	
	
	
	public static Funcionario funcionario(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Funcionario aux = new Funcionario();
		String s;

		s = request.getParameter("codFuncionario");
		if (s != null && !s.isEmpty()) {
			try{
			aux.setCodFuncionario(Integer.parseInt(s));
			} catch(NumberFormatException e){
				e.printStackTrace();
			}
		}

		s = request.getParameter("nome");
		if (s != null && !s.isEmpty()) {
			aux.setNome(s);
		}

		s = request.getParameter("cpf");
		if (s != null && !s.isEmpty()) {
			aux.setCpf(s);
		}

		s = request.getParameter("fone");
		if (s != null && !s.isEmpty()) {
			aux.setFone(s);
		}

		s = request.getParameter("email");
		if (s != null && !s.isEmpty()) {
			aux.setEmail(s);
		}

		s = request.getParameter("nascimento");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setNascimento(sdf.parse(s));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		s = request.getParameter("salario");
		if (s != null && !s.isEmpty()) {
			try{
			aux.setSalario(new BigDecimal(s));
			} catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		return aux;
	}

}
	
	

