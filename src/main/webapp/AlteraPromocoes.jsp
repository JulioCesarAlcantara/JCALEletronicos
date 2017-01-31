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
        <title> Altera Promoções</title>
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
            <center><h1 class="well">Atualizar Promoções</h1></center>
            <div class="col-lg-12 well">
                <div class="row">
                    <form class="form-signin" action="promocao" method="post">
                        <a href="produtoPromocao?cmd=update&id=${promocaoList.get(0).idPromocao}"> Gerenciar Produtos desta promoção </a><br/><br/>
                        <input type="hidden" name="cmd" value="saveUpdate"/>
                        <input type="hidden" name="id" value="${promocaoList.get(0).idPromocao}"/>
                        <div class="col-sm-12">
                            <div class="row">
                                <div class="col-sm-12 form-group">
                                    <label>Nome da Promoção</label>
                                    <input type="text" placeholder="Entre com o nome aqui .." required autofocus class="form-control" name="nomePromo" value="${promocaoList.get(0).nomePromocao}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Data de Início da Promoção</label>
                                    <input type="text" placeholder="Entre com a data de início aqui.." required class="form-control" name="dataIni" value="${promocaoList.get(0).dataComecoPromocao}">
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label>Data de Término da promoção</label>
                                    <input type="text" placeholder="Entre com a data de término aqui.." required class="form-control" name="dataFim" value="${promocaoList.get(0).dataFimPromocao}" >
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Percentual de Desconto da Promoção(%)</label>
                                    <input type="text" placeholder="Entre com o valor do desconto aqui .." required class="form-control" name="descontoPromo" value="${promocaoList.get(0).descontoPromocao}">
                                </div>	
                                <div class="col-sm-6 form-group">
                                    <label>Status da Promoção</label>
                                    <select name="statusPromo" required class="form-control selectpicker" >
                                        <c:if test= "${promocaoList.get(0).statusPromocao eq 'A'}">
                                            <option value="A" selected="selected" >Ativa</option>
                                            <option value="I" >Inativa</option>
                                        </c:if>
                                        <c:if test= "${promocaoList.get(0).statusPromocao eq 'I'}">
                                            <option value="A" >Ativa</option>
                                            <option value="I" selected="selected" >Inativa</option>
                                        </c:if>
                                    </select>

                                </div>	
                            </div>
                            <input type="submit" class="btn btn-lg btn-success" value="Salvar Alterações">
                        </div>
                    </form> 
                </div>
            </div>
        </div>
    </body>
</html>
