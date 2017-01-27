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
        <title> Cadasto de Clientes</title>
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
                    <a class="navbar-brand" href="#"><span>JCALEletronicos</span></a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <br><a href="TelaDeProdutos.jsp">Home</a>
                        </li>
                        <li>
                            <br><a href="CadastroClientes.jsp">Novo Cliente</a>
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
            <h3 class="well">Listagem dos Usuarios</h3>
            <div class="col-lg-12 well">
                <div class="row">
                    <table>
                        <tr>
                            <th><h4> ID - Atualizar&nbsp; </h4></th>
                            <th><h4> Nome&nbsp; </h4></th>
                            <th><h4> Excluir&nbsp; </h4></th>
                        </tr>
                        <c:forEach var="lista" items="${ requestScope.listaClientes }">
                            <tr>
                                <td><a href="clientes?cmd=update&id=${lista.idCliente}"> ${lista.idCliente} &nbsp;</a></td>
                                <td>${lista.primeiroNomeCliente} ${lista.segundoNomeCliente}&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td><a href="clientes?cmd=del&id=${lista.idCliente}"> Excluir</a></td>
                            </c:forEach>
                    </table>

                </div>
            </div>
        </div>
    </body>
</html>
