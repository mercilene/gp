<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath()%>/">Sistema de Gerenciamento de Projeto</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="<%=request.getContextPath()%>/funcionario/listar">Cadastro de Funcionário</a></li>
            <li><a href="<%=request.getContextPath()%>/projeto/pesquisar">Pesquisar Projeto</a></li>
            <li><a href="<%=request.getContextPath()%>/tarefa/inserir">Incluir Tarefa em Requisito</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>