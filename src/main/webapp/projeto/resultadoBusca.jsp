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
        <h1>Projetos encontrados</h1>
      </div>
      
      <table class="table">
      <thead>
      	<tr>
      		<th>Código</th>
      		<th>Nome</th>
      		<th>Descrição</th>
      		<th>Data de Entrega</th>
      		<th>Ação</th>
      	</tr>
      </thead>
      	<tbody>
      	 <c:forEach items="${itens}" var="x">
      	 <tr>
      		<td>${x.codProjeto}</td>
      		<td>${x.nome}</td>
      		<td>${x.descricao}</td>
      		<td>${x.dataEntrega}</td>
      		<td><a href="<%=request.getContextPath()%>/projeto/detalhes?cod=${x.codProjeto}" 
      		class="btn btn=primary btn-xs">Detalhes</a></td>
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
