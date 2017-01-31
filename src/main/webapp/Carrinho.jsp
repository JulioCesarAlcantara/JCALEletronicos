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
        <link href="CSS.css" rel="stylesheet" type="text/css">
        <title> Login</title>
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
                <div class="row">                   
                    <div>  

                        <table style="width: 100%" class="table">
                            <tr>
                                <th> Nome do Produto</th>
                                <th> Descrição do Produto</th>
                                <th> Preço do Produto </th>
                                <th> Excluir </th>
                            </tr>   
                            <c:forEach var="lista" items="${requestScope.listaDeProdutosNoCarrinho}"> 
                                <tr>
                                    <td> ${lista.nomeProduto} </td> 
                                    <td> ${lista.descricaoProduto} </td>
                                    <td> R$ ${lista.precoProduto} </td>
                                    <td> 
                                        <form action="Carrinho" method="get" id="ex"> 
                                            <input type="hidden" name="cmd" value="del"/>
                                            <input type="hidden" name="idProduto" value="${lista.idProduto}"/>
                                            <input type="submit" class="btn btn-danger col-lg-6 col-md-3 col-sm-4 col-xs-2" value="Excluir" onClick="location.reload()"/>
                                        </form>   
                                    </td>
                                </tr>
                            </c:forEach> 
                        </table> 

                        <table style="width: 100%" class="table" id="table-total">
                            <tr>
                                <th rowspan="4"> Total </td>
                                <td></td>
                                <td> <input type="text" name="total" value="R$ ${requestScope.total.get(0)}" readonly="true" class="form-control text-center"/></td>
                                <td></td>
                            </tr>
                        </table>
                       <form action="Carrinho" method="get"> 
                            <input type="hidden" name="cmd" value=finalizaCompra/>
                            <input type="hidden" name="total" value="${requestScope.precoTotal}"/>
                            <%HttpSession sessao = request.getSession(false);%>
                            <input type="hidden" name="idUsua" value="<%out.print(sessao.getAttribute("idUsuarioLogin").toString());%>">
                            <input type="submit" class="btn alinhado-direita btn-danger" value="" />
                        </form>  

                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
