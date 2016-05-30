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
        <h1>Escolha um requisito</h1>
      </div>
      
      <table class="table">
      <thead>
      	<tr>
      		<th>Código</th>
      		<th>Descrição</th>
      		<th>Horas Previstas</th>
      		<th>Custo</th>
      		<th>Ação</th>
      	</tr>
      </thead>
      	<tbody>
      	 <c:forEach items="${itens}" var="x">
      	 <tr>
      		<td>${x.codRequisito}</td>
      		<td>${x.descricao}</td>
      		<td>${x.horasPrevistas}</td>
      		<td>${x.custo}</td>
      		<td><a href="<%=request.getContextPath()%>/tarefa/nova?codRequisito=${x.codRequisito}" 
      		class="btn btn-primary btn-xs">Escolher</a></td>
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
