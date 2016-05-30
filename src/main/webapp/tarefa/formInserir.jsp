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
        <h1>Inserir nova tarefa para o projeto: ${item.projeto.nome}</h1>
      </div>
     
      <form method="get" name="myform" class="form-horizontal" 
     action="<%=request.getContextPath()%>/tarefa/inserir">
     
     <!-- Importante! N�o esque�a de repassar o codigo do projeto -->
     <input type="hidden" name="codProjeto" values="${item.projeto.codProjeto}"/>
     
         
     <div class="form-group">
     		<div class="col-sm-offset-2 col-sm-10">
     			<ul>
     				<c:forEach items="${erros}" var="msg">
     					<li class="erro">${msg}</li>
     				</c:forEach>
     			</ul>
     		</div>
     	</div>
     
     
     	<div class="form-group">
     		<label class="col-sm-2 control-label" for="descricao">Descri��o:</label>
     			<div class="col-sm-5">
     				<input type="text" name="descricao" id="descricao" value="${item.descricao}" required="required" class="form-control"/>
     			</div>
     	</div>
     	<div class="form-group">
     		<label class="col-sm-2 control-label" for="horas">Horas:</label>
     			<div class="col-sm-5">
     				<input type="text" name="horas" id="horas" value="${item.horas}" required="required" class="form-control"/>
     			</div>
    </div>
    
    
    <div class ="form.group">
    <label class="col-sm-2 control-Label" for="funcionario">Selecione o funcion�rio</label>
    <div class="col-sm-5">
    
    	<select name="codFuncionario" class="form-control">
    	<option value="">--Selecione o funcion�rio--</option>
    		<c:forEach items="${funcionarios}" var="x">
    		<option value="${x.codFuncionario}" <c:if test="${x == funcionarioSelecionado}">selected="selected"</c:if>>
    		${x.nome}, <fmt:setLocale value="pt-BR"/><fmt:formatNumber type="currency" value="${x.salario}" />
    		</option>
    		</c:forEach>
      	</select>
    </div>
    </div>
    
    
    
    <div class="form-group">
     		<div class="col-sm-offset-2 col-sm-10">
     			<button type="submit" class="btn btn-primary">Inserir</button>
     			<a href="<%=request.getContextPath()%>/tarefa/funcionarios" 
     			class="btn btn-default">Voltar</a>
     		</div>
     	</div>
    
    

  <jsp:include page="/resources/templates/rodape.jsp"/>


   
    <!-- Core JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery/1.11.3/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>
