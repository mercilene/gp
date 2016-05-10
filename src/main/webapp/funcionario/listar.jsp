<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Sistema de Gerenciamento de Projeto</title>

    <!-- Bootstrap core CSS -->
    <link
     href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" 
     rel="stylesheet">

    <!-- Custom styles for this template -->
    <link 
    href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css" 
    rel="stylesheet">
 </head>

  <body>

    <jsp:include page="/resources/templates/navbar.jsp"/>
    

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Funcionários</h1>
      </div>
      
      <div class="row">
      	<div class="col-sm-2">
      		<form class="navbar-form" action="<%=request.getContextPath()%>/funcionario/novo">
      			<button type="submit" class="btn btn-primary">Inserir novo</button>
      		</form>
      	</div>
      	<div class="col-sm-6">
      		<form class="navbar-form" action="<%=request.getContextPath()%>/funcionario/filtrar">
      			<div class="form-group">
      				<input type="text" name="busca" placeholder="Digite um nome" class="form-control"/>
      			</div>
      			<button type="submit" class="btn btn-success">Filtrar</button>
      		</form>
      	</div>
      </div>
      
      <table class="table">
    	<thead>
    		<tr>
    			<th>Código</th>
    			<th>Nome</th>
    			<th>CPF</th>
    			<th>Fone</th>
    			<th>Email</th>
    			<th>Data de Nascimento</th>
    			<th>Salário</th>
    			<th>Ação</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${itens}" var="x">
    			<tr>
    				<td>${x.codFuncionario}</td>
    				<td>${x.nome}</td>
    				<td>${x.cpf}</td>
    				<td>${x.fone}</td>
    				<td>${x.email}</td>
    				<td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${x.nascimento}"/></td>
    				<td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.salario}"/></td>
    				<td><a href="<%=request.getContextPath()%>/funcionario/editar?cod=${x.codFuncionario}" class="btm btm-primary btn-xs">Editar</a>
    				<a href="<%=request.getContextPath()%>/funcionario/remover?cod=${x.codFuncionario}" class="btm btm-danger btn-xs">Excluir</a></td>
    			</tr> 
    		</c:forEach>
    	</tbody>
    </table>
    </div>
    
    

  <jsp:include page="/resources/templates/rodape.jsp"/>


   
    <!-- Core JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery/1.11.3/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>
