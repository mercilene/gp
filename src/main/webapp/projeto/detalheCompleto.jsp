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
        <h1>Detalhes do Requisito do Projeto</h1>
      </div>
     
    <div>
    	<ul class="list-group">
    		<li class="list-group-item">Código: ${item.codProjeto}</li>
    		<li class="list-group-item">Descrição: ${item.descricao}</li>
    		<li class="list-group-item">Horas Previstas: ${item.horasPrevistas}</li>
    		<li class="list-group-item">Custo: ${item.custo}</li>
    		<li class="list-group-item">Extrapolado: <fmt:setLocale value="pt_BR" /> <fmt:formatNumber type="currency" value="${item.extrapolado}"/></li>
       	</ul>
    </div>
    
    
    <div class="container">
      <div class="page-header">
        <h1>Detalhes da Tarefa</h1>
      </div>
    
    <div>
    	<table class="table">
    		<thead>
    		<tr>
    			<th>Código da Tarefa</th>
    			<th>Horas</th>
    			<th>Nome do Funcionário</th>
    			<th>Email do Funcionário</th>
       		</tr>
    			</thead>
    			<tbody>
    			<c:forEach items="${item.tarefas}" var="x">
    			<tr>
    				<td>$.{x.codTarefa}</td>
    				<td>$.{x.horas}</td>
    				<td>$.{x.funcionario.nome}</td>
    				<td>$.{x.funcionario.email}</td>
    		 </tr>
    		 </c:forEach>
    			</tbody>
    	</table>
    </div>
       
    <div>
    	<a href="<%=request.getContextPath()%>/projeto/pesquisar"
    	class="btn btn-primary">Nova Pesquisa</a>
    </div>
  
</div>

  <jsp:include page="/resources/templates/rodape.jsp"/>


   
    <!-- Core JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery/1.11.3/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>
