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
        <link href="/Arquivo.css" rel="stylesheet" type="text/css">
        <title> Alteração de Produtos</title>

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
            <h1 class="well">Alteração de Produtos</h1>
            <div class="col-lg-12 well">
                <div class="row">
                    <form action="cadPro" method="post">
                        <input type="hidden" name="cmd" value="saveUpdate"/>
                        <input type="hidden" value="${listaProdutos.get(0).idProduto}" name="id">

                        <div class="col-sm-12">
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Nome do produto</label>
                                    <input type="text" placeholder="Entre com o nome aqui .." required class="form-control" name="nome" value="${listaProdutos.get(0).nomeProduto}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-12">
                                    <label> Descrição</label>
                                    <textarea placeholder="Entre com a descrição aqui.." rows="3" required name="descricao" class="form-control">${listaProdutos.get(0).descricaoProduto}</textarea>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>Preço</label>
                                    <input type="text" placeholder="Entre com preço aqui.." required class="form-control" name="preco" value="${listaProdutos.get(0).precoProduto}">
                                </div>	                  	
                                <div class="col-sm-4 form-group">
                                    <label>Categoria</label>
                                    <select name="categoria" required class="form-control selectpicker" >
                                        <c:if test="${listaProdutos.get(0).categoriaProduto eq 'ap'}">
                                            <option value="ap" selected>Aparelho</option>
                                            <option value="ac">Acessórios</option>
                                        </c:if>
                                        <c:if test="${listaProdutos.get(0).categoriaProduto eq 'ac'}">
                                            <option value="ap">Aparelho</option>
                                            <option value="ac" selected>Acessórios</option>
                                        </c:if> 
                                    </select>
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>Quantidade</label>
                                    <input type="text" placeholder="Quantidade deste produto.." required class="form-control" name="quantidade" value="${listaProdutos.get(0).quantidadeEstoqueProduto}">
                                </div>
                            </div>	

                            <input type="submit" class="btn btn-lg btn-success" value="Alterar">
                        </div>
                    </form> 
                </div>
            </div>
        </div>
    </body>
</html>
