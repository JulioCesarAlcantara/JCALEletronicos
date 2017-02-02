<%@page import="cdc.model.PromocaoProduto"%>
<%@page import="cdc.model.Produto"%>
<%@page import="cdc.model.PromocaoProdutoDAO"%>
<%@page import="cdc.model.Promocao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
              rel="stylesheet" type="text/css">
        <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
              rel="stylesheet" type="text/css">
        <link href="/CSS.css" rel="stylesheet" type="text/css">
        <link href="/Arquivo.css" rel="stylesheet" type="text/css">
        <title> Cadastro de Promoções</title>
    </head>

    <body>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><span><h3>JCALEletronicos</h3></span></a>
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

        <div class="container">
            <center><h1 class="well">Associa Produto à Promoção</h1></center>
            <div class="col-lg-12 well">
                <div class="row">
                    <form class="form-signin" action="promocaoProduto" method="post">
                        <input type="hidden" name="cmd" value="saveAdd"/>
                        <%
                            List<Promocao> listaDePromocoes = new ArrayList<Promocao>();
                            PromocaoProdutoDAO promoProduto = new PromocaoProdutoDAO();
                            listaDePromocoes = promoProduto.buscaPromocoes();
                            request.setAttribute("listaDePromocoes", listaDePromocoes);

                            List<Produto> listaDeProdutos = new ArrayList<Produto>();
                            PromocaoProdutoDAO prodPromo = new PromocaoProdutoDAO();
                            listaDeProdutos = prodPromo.buscaProdutos();
                            request.setAttribute("listaDeProdutos", listaDeProdutos);

                        %>
                        <div class="col-sm-12">
                            <a href="promocao?cmd=listar"<input type="button" class="btn form-signin"> <h3> << voltar </h3></a>
                            <br><div class="row">
                                <div class="col-sm-6 form-group">
                                    <label> Escolha uma promoção</label> <br />
                                    <br><select class="form-control" required autofocus="" name ="idPromo">
                                        <option value="-1">Escolha uma promoção</option>
                                        <c:forEach var="promocao" items="${requestScope.listaDePromocoes}">
                                            <option value="${promocao.idPromocao}">${promocao.nomePromocao}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label> Escolha um produto</label> <br />
                                    <br><select class="form-control" required="" name ="idProd">
                                        <option value="-1">Escolha uma promoção</option>
                                        <c:forEach var="produto" items="${requestScope.listaDeProdutos}">
                                            <option value="${produto.idProduto}">${produto.nomeProduto}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="row form-group" >
                                <center><input type="submit" class="btn btn-lg btn-success" value="Associar" onClick="location.reload()"></center>
                            </div>
                        </div>
                    </form> 
                </div>

                <%                    List<PromocaoProduto> listaDePromocoesEProdutos = new ArrayList<PromocaoProduto>();
                    PromocaoProdutoDAO buscaTudo = new PromocaoProdutoDAO();
                    listaDePromocoesEProdutos = buscaTudo.buscaProdutosEPromocoes();
                    request.setAttribute("listaDePromocoesEProdutos", listaDePromocoesEProdutos);
                %>

                <table style="width: 100%" class="table">
                    <tr>
                        <th> Nome da Promoção</th>
                        <th> Nome do Produto</th>
                        <th> Excluir </th>
                    </tr>                                
                    <c:forEach var="lista" items="${requestScope.listaDePromocoesEProdutos}">
                        <tr>
                            <td> ${lista.nomePromocao} </td> 
                            <td> ${lista.nomeProduto} </td>                           
                            <td> 
                                <form action="promocaoProduto" method="post" id="ex"> 
                                    <input type="hidden" name="cmd" value="del"/>
                                    <input type="hidden" name="idPromocaoProduto" value="${lista.idPromocaoProduto}"/>
                                    <input type="submit" class="btn btn-danger col-lg-6 col-md-1 col-sm-2 col-xs-1" value="Excluir" onClick="location.reload()"/>
                                </form>   
                            </td>
                        </tr>
                    </c:forEach> 
                </table> 

            </div>
        </div>
    </body>
</html>
