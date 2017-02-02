<%@page import="cdc.model.Promocao"%>
<%@page import="cdc.model.PromocaoDAO"%>
<%@page import="cdc.model.ProdutoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cdc.model.MostraProdutoImagem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>  
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="/CSS.css" rel="stylesheet" type="text/css">
        <link href="/Arquivo.css" rel="stylesheet" type="text/css">
        <title> Tela Principal</title>
    </head>

    <body>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><span><h3>JCALEletronicos </h3></span></a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <%
                            HttpSession sessao = request.getSession(true);
                            String tipoUsuario = "c";
                            boolean newSession;
                            if (sessao.isNew()) {
                                sessao.invalidate();
                                newSession = true;
                            } else {
                                sessao.setMaxInactiveInterval(500);
                                try {
                                    tipoUsuario = (String) sessao.getAttribute("usuarioTipo").toString();
                                } catch (Exception ex) {
                                    tipoUsuario = "c";
                                    newSession = true;
                                }

                                tipoUsuario = (String) sessao.getAttribute("usuarioTipo").toString();
                                newSession = false;
                            }
                        %>

                        <li>
                            <a href="TelaDeProdutos.jsp">Home</a>
                        </li>
                        <%
                            if (tipoUsuario.equalsIgnoreCase("a") || tipoUsuario.equalsIgnoreCase("v")) {%>

                        <li>
                            <a href="clientes?cmd=listar">Gerenciar Clientes</a>
                        </li>
                        <%}%>
                        <%
                            if (tipoUsuario.equalsIgnoreCase("a")) {
                        %>
                        <li>
                            <a href="usuarios?cmd=listar">Gerenciar Usuarios</a>
                        </li>
                        <%}%>

                        <%
                            if (tipoUsuario.equalsIgnoreCase("g")) {
                        %>

                        <li>
                            <a href="promocao?cmd=listar">Gerenciar Promoções</a>
                        </li>
                        <%}%>

                        <%
                            if (tipoUsuario.equalsIgnoreCase("e")) {
                        %>
                        <li>
                            <a href="cadPro?cmd=listar">Gerenciar Produtos</a>
                        </li>

                        <%}
                            if (tipoUsuario.equalsIgnoreCase("c") && !newSession) {
                                String idCliente = sessao.getAttribute("idLoginUsuario").toString();
                        %>
                        <li>
                            <a href="clientes?cmd=update&id=<%out.println(idCliente);%>">Alterar meus Dados</a>
                        </li>


                        <li>
                            <form action="Carrinho" method="get">
                                <span>
                                    <img height="35" width="35" title="Carrinho" src="data:image/png;base64,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">
                                    <input type="submit" class="form-control" value="Meu Carrinho"/>  
                                </span>
                            </form>
                        </li>
                        <%}%>

                        <li>
                            <a href="LoginDeUsuarios.jsp">Login</a>
                        </li>

                        <li>
                            <%if (!newSession)%> <a href="login?cmd=sair">Sair</a>
                        </li>

                        <li>
                            <div class="dropdown">
                                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Promoções
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu">

                                    <% PromocaoDAO 
                                        promocoes = new PromocaoDAO();
                                      List<Promocao> listaPromocoes = promocoes.listaTodos();

                                        for (Promocao promo : listaPromocoes) {%>
                                    <li><a href="promocao?cmd=vitrinePromo&id=<%out.print(promo.getIdPromocao());%>"><%out.print(promo.getNomePromocao());%></a></li> 
                                        <%}%>

                                </ul>
                            </div>    
                        </li>
                    </ul>

                </div>
                <br>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="text-center">Pesquisar</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-3 col-md-6">
                        <form action="pesqProduto" method="post">
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="hidden" name="cmd" value="pesquisa"/>
                                    <input type="text" class="form-control" placeholder="Pesquise por um produto aqui.." name="pesquisaPalavra">
                                    <span class="input-group-btn">
                                        <button class="btn btn-success" type="submit">Go</button>>
                                    </span>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <footer class="section"> 
                <div class="container"> 
                    <div class="row"> 
                        <div class="col-sm-4 form-group ">
                            <br><a href="TelaDeAcessorios.jsp" ><button class="btn btn-lg btn-primary btn-block">Acessórios</button></a> 
                        </div>
                        <div class="col-sm-4 form-group text-right">
                            <br><a href="TelaDeAparelhos.jsp" > <button class="btn btn-lg btn-success btn-block">Aparelhos</button></a>
                        </div>
                    </div>
                </div>
            </footer>


            <%
                List<MostraProdutoImagem> lista = new ArrayList<MostraProdutoImagem>();
                ProdutoDAO produto = new ProdutoDAO();
                String pesquisa = request.getParameter("pesquisaPalavra");

                if (pesquisa != null) {
                    lista = produto.buscaListaDeProdutosPesquisados(pesquisa);
                } else {
                    lista = produto.listaTodos();
                }

                if (lista.isEmpty()) {
                    response.sendRedirect("EmptyScreen.jsp");
                }
            %>
            <div class="section">
                <div class="container">
                    <div class="row">
                        <% for (MostraProdutoImagem proList : lista) {%>
                        <form action="MontaCarrinho" method="get"> 
                            <input type="hidden" name="idProduto" value="<%out.print(proList.getIdProduto());%>"/>      
                            <div class="col-md-3">
                                <img src="<%out.print(proList.getImagem1());%>"
                                     class="img-responsive">
                                <h2><%out.print(proList.getNomeProduto());%></h2>
                                <p><%out.print(proList.getDescricaoProduto());%></p>
                                <input type="submit" value="Efetuar Comprar" class="btn btn-primary">
                            </div>
                        </form>
                        <%}%>
                    </div>
                </div>
            </div>
            <footer class="section section-primary"> 
                <div class="container"> 
                    <div class="row"> 
                        <div class="col-sm-8"> 
                            <h1>Desenvolvimento de Aplicações Web II</h1> 
                            <p>Este sistema foi desenvolvido para a disciplina de Desenvolvimento<br>
                                de Aplicações para Web utilizando linguagem Java. O intuito dela <br>
                                é ampliar os conhecimentos na área de desenvolvimento.</p>
                        </div><div class="col-sm-4"> 
                            <p class="text-info text-right"> <br><br></p>
                            <div class="row"> 
                                <div class="col-md-12 hidden-lg hidden-md hidden-sm text-left"> 
                                    <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a> 
                                    <a href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a> 
                                    <a href="#"><i class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a> 
                                    <a href="#"><i class="fa fa-3x fa-fw fa-github text-inverse"></i></a> 
                                </div></div><div class="row">
                                <div class="col-md-12 hidden-xs text-right"> 
                                    <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a> 
                                    <a href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a> 
                                    <a href="#"><i class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a> 
                                    <a href="#"><i class="fa fa-3x fa-fw fa-github text-inverse"></i></a> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
    </body>
</html>
