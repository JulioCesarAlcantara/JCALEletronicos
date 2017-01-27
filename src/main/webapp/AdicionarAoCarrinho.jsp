<%-- 
    Document   : Carrinho
    Created on : 26/01/2017, 23:53:04
    Author     : cesar
--%>

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
        <title> Carrinho de compras</title>
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
                        <c:forEach var="lista" items="${requestScope.listaDeProdutosDoCarrinho}">                      
                            <table style="width: 100%" class="table">
                                <tr>
                                    <th> Nome do Produto</th>
                                    <th> Descrição do Produto</th>
                                    <th> Preço do Produto </th>
                                    <th> Excluir </th>
                                </tr>                                
                                <tr>
                                    <td> ${lista.nomeProduto} </td> 
                                    <td> ${lista.descricaoProduto} </td>
                                    <td> R$ ${lista.precoProduto} </td>
                                    <td> 
                                        <form action="ExcluiDoCarrinho" method="get" id="ex"> 
                                            <input type="hidden" name="cmd" value="del"/>
                                            <input type="hidden" name="idProduto" value="${lista.idProduto}"/>
                                            <input type="submit" class="btn btn-danger col-lg-6 col-md-1 col-sm-2 col-xs-1" value="Excluir" onClick="location.reload()"/>
                                        </form>   
                                    </td>
                                </tr>
                            </table> 

                        </c:forEach> 
                        <table style="width: 100%" class="table" id="table-total">
                            
                            <tr>
                                <th rowspan="4"> Total </td>
                                <td></td>
                                <td> <input type="text" name="total" value="10" readonly="true" class="form form-control col-lg-2 text-center"/></td>
                                <td></td>
                            </tr>
                        </table>

                </div>
            </div>
        </div>


    </body>
</html>

