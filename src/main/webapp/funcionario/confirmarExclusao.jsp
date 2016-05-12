<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Sistema de Gerenciamento de Projeto</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css" rel="stylesheet">
 </head>

  <body>

    <jsp:include page="/resources/templates/navbar.jsp"/>
    

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Confirmar Exclusão de Funcionário</h1>
      </div>
      
      <div>
      	<ul class="list-group">
      	<li class="list-group-item">Código: ${item.codFuncionario}</li>
      	<li class="list-group-item">Nome: ${item.nome}</li>
      	<li class="list-group-item">CPF: ${item.cpf}</li>
      	<li class="list-group-item">Telefone: ${item.fone}</li>
      	<li class="list-group-item">Email: ${item.email}</li>
      	<li class="list-group-item">Data de Nascimento: <fmt:formatDate type="date" pattern="dd/mm/yyyy" value="${item.nascimento}"/></li>
      	<li class="list-group-item">Salário: <fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${item.salario}"/></li>
      	</ul>
     </div>
          
     	<div>
    	 	<a href="<%=request.getContextPath()%>/funcionario/excluir?cod=${item.codFuncionario}" class="btn btn-danger">Excluir</a>
     		<a href="<%=request.getContextPath()%>/funcionario/listar" class="btn btn-default">Voltar</a>
     	</div>   
      </div>  	

  <jsp:include page="/resources/templates/rodape.jsp"/>

   
    <!-- Core JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery/1.11.3/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>
