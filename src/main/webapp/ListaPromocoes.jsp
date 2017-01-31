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
        <div id ="redor">
            <div class="container">
                <div class="row" >
                    <div class="col-sm-6 form-group">
                        <br><a href="CadastroDePromocoes.jsp" ><button class="btn btn-lg btn-primary btn-block" type="submit"><< Cadastrar nova Promoção</button></a> 
                    </div>
                    <div class="col-sm-6 form-group">
                        <br><a href="AssociaProdutoNaPromocao.jsp" > <button class="btn btn-lg btn-success btn-block" type="submit">Associar Produtos à Promoções >></button></a>
                    </div>
                </div>
                <div style="padding: 10px; margin:10px;">
                    <table style="width: 100%" class="table table-responsive">
                        <tr>
                            <th><center>Atualizar</center></th>
                        <th><center> Nome </center> </th>
                        <th><center>Excluir</center></th>
                        </tr>
                        <c:forEach var="lista" items="${requestScope.promocaoList}">
                            <tr>
                                <td><center><a href="promocao?cmd=update&id=${lista.idPromocao}"> Alterar </a></center></td>
                            <td><center>${lista.nomePromocao}</center></td>
                            <td><center><a href="promocao?cmd=del&id=${lista.idPromocao}"> Excluir</a></center></td>
                            </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
