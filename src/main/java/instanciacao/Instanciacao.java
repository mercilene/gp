package instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Funcionario;
import dominio.Projeto;
import dominio.Requisito;
import dominio.Tarefa;
import servico.ClienteServico;
import servico.FuncionarioServico;
import servico.ProjetoServico;
import servico.RequisitoServico;
import servico.ServicoException;
import servico.TarefaServico;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			//sdf.parse("01/01/2000");
			
		//Funcionario f0 = new Funcionario(codFuncionario, nome, cpf, fone, email, nascimento, salario);
		Funcionario f1 = new Funcionario(null, "Rafael", "302.502.775-41", "(34)99123-4567", "rafael@lojistaonline.com.br", sdf.parse("08/03/2016"), new BigDecimal("1700.00"));
		Funcionario f2 = new Funcionario(null, "Ayne", "302.582.875-91", "(34)99123-4068", "ayne@lojistaonline.com.br", sdf.parse("16/03/1986"), new BigDecimal("1600.00")); 
		Funcionario f3 = new Funcionario(null, "Juliano", "805.582.785-90", "(34)99123-4569", "juliano@lojistaonline.com.br", sdf.parse("17/03/1986"), new BigDecimal("1500.00")); 
		 	
	
		//Cliente c0 = new Cliente(codCliente, nome, cpf, email);
		Cliente c1 = new Cliente(null, "Mariana Rom", "502.335.668-90","mari@ksa.com.br");
		Cliente c2 = new Cliente(null, "Pedro Garcia", "802.935.768-60", "pedro@business.br");
		
		//Projeto p0 = new Projeto(codProjeto, nome, descricao, dataEntrega, cliente);
		Projeto p1 = new Projeto(null, "Site", "Criar Institucional", sdf.parse("25/04/2016"), c1);
		Projeto p2 = new Projeto(null, "E-commerce", "Criar loja", sdf.parse("10/05/2016"), c2);
	    Projeto p3 = new Projeto(null, "Blog", "Criar postagens", sdf.parse("25/06/2016"), c2);
				
		//Requisito r0 = new Requisito(codRequisito, descricao, horasPrevistas, custo, projeto);
		Requisito r1 = new Requisito(null, "sintonia", 2, new BigDecimal("50.00"), p1);
		Requisito r2 = new Requisito(null, "escopo", 5, new BigDecimal("150.00"), p1);
		Requisito r3 = new Requisito(null, "desenhar layout", 10, new BigDecimal("1000.00"), p1);
		Requisito r4 = new Requisito(null, "desenvolvimento", 20, new BigDecimal("2000.00"), p2) ;
		Requisito r5 = new Requisito(null, "teste", 5, new BigDecimal("1200.00"), p2);
		Requisito r6 = new Requisito(null, "documentação", 5, new BigDecimal("150.00"), p2);
		Requisito r7 = new Requisito(null, "postagens", 2, new BigDecimal("120.00"), p3);
		Requisito r8 = new Requisito(null, "validação", 2, new BigDecimal("40.00"), p3);
		Requisito r9 = new Requisito(null, "entrega", 2, new BigDecimal("50.00"), p3);
				
								
		//Tarefa t0 = new Tarefa(codTarefa, descricao, horas, funcionario, requisito)
		Tarefa t1 = new Tarefa(null, "sintonia", 1, f1, r1);
		Tarefa t2 = new Tarefa(null, "reunião", 1, f2, r1);
		Tarefa t3 = new Tarefa(null, "análise negócio", 2, f3, r2);
		Tarefa t4 = new Tarefa(null, "desenhar", 10, f1, r2);
		Tarefa t5 = new Tarefa(null, "documentação", 4, f3, r3);
		Tarefa t6 = new Tarefa(null, "sintonia", 1, f1, r3);
		Tarefa t7 = new Tarefa(null, "análise requisito", 2, f2, r4);
		Tarefa t8 = new Tarefa(null, "desenvolvimento", 20, f2, r4);
		Tarefa t9 = new Tarefa(null, "análise sistema", 1, f1, r5);
		Tarefa t10 = new Tarefa(null, "simulações", 4, f3, r5);
		Tarefa t11 = new Tarefa(null, "simulações", 2, f2, r6);
		Tarefa t12 = new Tarefa(null, "registrar ações", 2, f1, r6);
		Tarefa t13 = new Tarefa(null, "publicar conteúdo", 1, f3, r7);
		Tarefa t14 = new Tarefa(null, "publicar imagens", 1, f3, r7);
		Tarefa t15 = new Tarefa(null, "publicar domínio", 2, f2, r8);
		Tarefa t16 = new Tarefa(null, "navegar domínio", 1, f1, r8);
		Tarefa t17 = new Tarefa(null, "validação", 1, f2, r9);
		Tarefa t18 = new Tarefa(null, "apresentação", 1, f3, r9);
		
	
		
		FuncionarioServico fs = new FuncionarioServico();
		TarefaServico ts = new TarefaServico();
		RequisitoServico rs = new RequisitoServico();
		ProjetoServico ps = new ProjetoServico();
		ClienteServico cs = new ClienteServico();
		
	
				
		
		fs.inserir(f1);
		fs.inserir(f2);
		fs.inserir(f3);
		
		cs.inserirAtualizar(c1);
		cs.inserirAtualizar(c2);
		
		ps.inserirAtualizar(p1);
		ps.inserirAtualizar(p2);
		ps.inserirAtualizar(p3);
		
		rs.inserirAtualizar(r1);
		rs.inserirAtualizar(r2);
		rs.inserirAtualizar(r3);
		rs.inserirAtualizar(r4);
		rs.inserirAtualizar(r5);
		rs.inserirAtualizar(r6);
		rs.inserirAtualizar(r7);
		rs.inserirAtualizar(r8);
		rs.inserirAtualizar(r9);

		ts.inserir(t1);
		ts.inserir(t2);
		ts.inserir(t3);
		ts.inserir(t4);
		ts.inserir(t5);
		ts.inserir(t6);
		ts.inserir(t7);
		ts.inserir(t8);
		ts.inserir(t9);
		ts.inserir(t10);
		ts.inserir(t11);
		ts.inserir(t12);
		ts.inserir(t13);
		ts.inserir(t14);
		ts.inserir(t15);
		ts.inserir(t16);
		ts.inserir(t17);
		ts.inserir(t18);
									
				
		
	
		
		
		
	
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(f1);
		response.getWriter().append(f1.toString());
		em.persist(f2);
		response.getWriter().append(f2.toString());
		em.persist(f3);
		response.getWriter().append(f3.toString());
		
		*/
		
		//em.persist(f1);
		//em.persist(f2);
		//em.persist(f3);
		//em.persist(c1);
		//em.persist(c2);
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(p3);
		//em.persist(r1);
		//em.persist(r2);
		//em.persist(r3);
		//em.persist(r4);
		//em.persist(r5);
		//em.persist(r6);
		//em.persist(r7);
		//em.persist(r8);
		//em.persist(r9);		
		//em.persist(t1);
		//em.persist(t2);
		//em.persist(t3);
		//em.persist(t4);
		//em.persist(t5);
		//em.persist(t6);
		//em.persist(t7);
		//em.persist(t8);
		//em.persist(t9);
		//em.persist(t10);
		//em.persist(t11);
		//em.persist(t12);
		//em.persist(t13);
		//em.persist(t14);
		//em.persist(t15);
		//em.persist(t16);
		//em.persist(t17);
		//em.persist(t18);
		
		
		/*em.getTransaction().commit();
		
		em.close();
		emf.close();*/		
		
		//response.getWriter().append("Custo Total do Projeto"+ r1 +"\n");
		//response.getWriter().append(r1.custoTotal() +"\n");
		
		response.getWriter().append("Pronto");
	}
		catch (ParseException e){
			response.getWriter().append("Erro ao instanciar data. Instância não criada!");
	}
		catch (ServicoException e){
			response.getWriter().append("Erro"+ e.getMessage());
		}
	}
}

