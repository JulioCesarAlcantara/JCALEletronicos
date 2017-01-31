<%-- 
    Document   : Carrinho
    Created on : 26/01/2017, 23:53:04
    Author     : cesar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title> Adicionar ao Carrinho</title>
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
                     <a class="navbar-brand"><span><h3> JCALEletronicos </h3></span></a>
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
                <div class="row col-md-3">   
                    <c:forEach var="lista" items="${requestScope.ItensDeProdutos}">                      
                            <table style="width: 25%" class="table table-responsive">
                                <tr>
                                    <td> <img src="${lista.imagem1}"> </td> 
                                    <td rowspan="3" valign="top">
                                        <div id="menu" >
                                            <form action="ItensDoCarrinho" method="get">
                                            <input type="hidden" name="idPro" value="${lista.idProduto}"/>
                                            <big><big><big><big><big><big><big><big><big><big><h2> ${lista.nomeProduto} </h2>
                                            <br><h4>${lista.descricaoProduto}</h4>
                                            <br><h3>R$ ${lista.precoProduto}</h3>
                                            <br><input type="submit" class="btn btn-success col-lg-6 col-md-1 col-sm-2 col-xs-1" value="Adicionar no Carrinho" />                                            
                                            </form>
                                        </div>
                                    </td> 
                                </tr> 
                                <tr>
                                    <td> <img src="${lista.imagem2}"> </td>
                                </tr>
                                <tr>
                                    <td> <img src="${lista.imagem3}"> </td>  
                                </tr>
                            </table> 
                        </c:forEach> 
                </div>
            </div>
        </div>
    </body>
</html>

