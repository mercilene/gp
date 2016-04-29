package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import dominio.Funcionario;

public class Instanciar {
	public static Funcionario funcionario(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Funcionario aux = new Funcionario();
		String s;

		s = request.getParameter("codFuncionario");
		if (s != null && !s.isEmpty()) {
			aux.setCodFuncionario(Integer.parseInt(s));
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
			aux.setSalario(new BigDecimal(s));
		}
		return aux;
	}

}
