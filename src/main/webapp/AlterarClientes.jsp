<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1 class="well">Alteração de Clientes</h1>
            <div class="col-lg-12 well">
                <div class="row">
                    <form class="form-signin" action="clientes" method="post">
                        <input type="hidden" name="cmd" value="saveUpdate"/>
                        <input type="hidden" name="idCliente" value="${listaClientes.get(0).idCliente}"/>
                        <div class="col-sm-12">
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Primeiro Nome</label>
                                    <input type="text" placeholder="Entre com 1º nome aqui .." class="form-control" name="primeiroNomeCliente" value="${listaClientes.get(0).primeiroNomeCliente}">
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label>Segundo Nome</label>
                                    <input type="text" placeholder="Entre com 2º nome aqui .." class="form-control" name="segundoNomeCliente" value="${listaClientes.get(0).segundoNomeCliente}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Telefone</label>
                                    <input type="text" placeholder="Entre com Telefone aqui.." class="form-control" name="telefoneCliente" value="${listaClientes.get(0).telefoneCliente}" >
                                </div>		
                                <div class="col-sm-6 form-group">
                                    <label>Email</label>
                                    <input type="text" placeholder="Entre com Email aqui.." class="form-control" name="emailCliente" value="${listaClientes.get(0).emailCliente}" >
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>Data de Nascimento</label>
                                    <input type="text" class="form-control" name="dataNascimentoCliente" value="${listaClientes.get(0).dataNascimentoCliente}" >
                                </div>		
                                <div class="col-sm-4 form-group">
                                     <label>Sexo</label>
                                    <select name="sexoCliente" class="form-control selectpicker" >
                                        <c:if test="${listaClientes.get(0).sexoCliente eq 'm'}" >                                      
                                            <option value="m" selected>Masculino</option>
                                            <option value="f" >Feminino</option>
                                        </c:if> 
                                        <c:if test="${listaClientes.get(0).sexoCliente eq 'f'}" >                                      
                                            <option value="m" >Masculino</option>
                                            <option value="f" selected>Feminino</option>
                                        </c:if> 
                                            
                                            
                                    </select>
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>CPF</label>
                                    <input type="text" placeholder="Cadastro de Pessoa Física aqui.." class="form-control" name="cpfCliente" value="${listaClientes.get(0).cpfCliente}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Endereço</label>
                                <textarea placeholder="Entre com o Endereço aqui.." rows="3" class="form-control" name="enderecoCliente">${listaClientes.get(0).enderecoCliente}</textarea>
                            </div>	
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>Cidade</label>
                                    <input type="text" placeholder="Entre com o nome da cidade aqui.." class="form-control" name="cidadeCliente" value="${listaClientes.get(0).cidadeCliente}" >
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>Estado</label>
                                    <input type="text" placeholder="Entre com o Estado aqui.." class="form-control" name="estadoCliente" value="${listaClientes.get(0).estadoCliente}" >
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>CEP</label>
                                    <input type="text" placeholder="Entre com o CEP aqui.." class="form-control" name="cepCliente" value="${listaClientes.get(0).cepCliente}" >
                                </div>		
                            </div>
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>Defina uma Senha</label>
                                    <input type="password" placeholder="Entre com sua nova senha aqui.." class="form-control" name="senhaCliente" value="${listaClientes.get(0).senhaCliente}" >
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
