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
        <h1>Pesquisar Projetos</h1>
      </div>
     
     <form method="get" name="myform" class="form-horizontal" 
     action="<%=request.getContextPath()%>/projeto/resultado">

     
     <div class="form-group">
     			<label class="col-sm-2 control-label" form="nome">Nome:</label>
     			<div class="col-sm-5">
     				<input type="text" name="nome" id="nome" value="" class="form-control"/> 
     			</div>
    </div>
    
    <div class="form-group">
    	<label class="col-sm-2 control-Label" form="dataMin">Data mínima:</label>
    	<div class="col-sm-5">
    		<input type="number" name="dataMin" id="dataMin" value="" required="required" class="form-control"/>
    	</div>
    </div>
    
    <div class="form-group">
    	<label class="col-sm-2 control-Label" form="dataMax">Data máxima:</label>
    	<div class="col-sm-5">
    		<input type="number" name="dataMax" id="dataMax" value="" required="required" class="form-control"/>
    	</div>
    </div>
     
     <div class="form-group">
     	<div class="col-sm-offset-2 col-sm-10">
     	 <button type="submit" class="btn btn-primary">Pesquisar</button>
     	 <a href="<%=request.getContextPath()%>" class="btn btn-default">Voltar</a>
     	</div>
     </div>
  </form>
 </div>
  

  <jsp:include page="/resources/templates/rodape.jsp"/>


   
    <!-- Core JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery/1.11.3/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>
