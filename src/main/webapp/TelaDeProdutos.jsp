<%@page import="cdc.model.ProdutoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cdc.model.MostraProdutoImagem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
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
                    <a class="navbar-brand" href="#"><span><h3> JCALEletronicos </h3></span></a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <br><a href="TelaDeProdutos.jsp">Home</a>
                        </li>
                        <li>
                            <br><a href="#">Contacts</a>
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
                                    <input type="text" class="form-control" placeholder="Pesquise por um produto aqui" name="pesquisaPalavra">
                                    <span class="input-group-btn">
                                        <a class="btn btn-success" type="submit">Go</a>
                                    </span>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <% List<MostraProdutoImagem> lista = new ArrayList<MostraProdutoImagem>();
            ProdutoDAO produto = new ProdutoDAO();
            String pesquisa = request.getParameter("pesquisaPalavra");
            out.print(pesquisa);
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
                    
                    <% for(MostraProdutoImagem proList : lista){%>
                    <form action="" method=""> 
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
