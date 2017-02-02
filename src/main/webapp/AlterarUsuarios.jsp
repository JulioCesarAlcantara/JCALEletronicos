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
        <title> Alteração de Usuários</title>
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
            <h1 class="well">Alteração de Usuários</h1>
            <div class="col-lg-12 well">
                <div class="row">
                    <form class="form-signin" action="usuarios" method="post">
                        <input type="hidden" name="cmd" value="saveUpdate"/>
                        <input type="hidden" name="idUsuario" value="${listaUsuarios.get(0).id}">
                        <div class="col-sm-12">
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Primeiro Nome</label>
                                    <input type="text" placeholder="Entre com 1º nome aqui .." class="form-control" name="primeiroNomeUsuario" value="${listaUsuarios.get(0).primeiroNome}">
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label>Segundo Nome</label>
                                    <input type="text" placeholder="Entre com 2º nome aqui .." class="form-control" name="segundoNomeUsuario" value="${listaUsuarios.get(0).segundoNome}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Telefone</label>
                                    <input type="text" placeholder="Entre com Telefone aqui.." class="form-control" name="telefoneUsuario" value="${listaUsuarios.get(0).telefone}">
                                </div>		
                                <div class="col-sm-6 form-group">
                                    <label>Email</label>
                                    <input type="text" placeholder="Entre com Email aqui.." class="form-control" name="emailUsuario" value="${listaUsuarios.get(0).email}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>Data de Nascimento</label>
                                    <input type="text" class="form-control" placeholder="Entre com a Data de Nascimento" name="dataNascimentoUsuario" value="${listaUsuarios.get(0).dataNascimento}">
                                </div>		
                                <div class="col-sm-4 form-group">
                                    <label>Sexo</label>
                                    <select name="sexoUsuario" class="form-control selectpicker" >
                                        <c:if test="${listaUsuarios.get(0).sexo eq 'm'}" >                                      
                                            <option value="m" selected>Masculino</option>
                                            <option value="f" >Feminino</option>
                                        </c:if> 
                                        <c:if test="${listaUsuarios.get(0).sexo eq 'f'}" >                                      
                                            <option value="m" >Masculino</option>
                                            <option value="f" selected>Feminino</option>
                                        </c:if> 
                                    </select>
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>Tipo de Usuário</label>
                                    <select name="tipoUsuario" class="form-control selectpicker" >
                                        <c:if test="${listaUsuarios.get(0).tipo eq 'a'}">
                                            <option value="a" selected>Administrador</option>
                                            <option value="g" >Gerente</option>
                                            <option value="e" >Encarregado</option>
                                            <option value="v" >Vendedor</option>  
                                        </c:if>
                                        <c:if test="${listaUsuarios.get(0).tipo eq 'g'}">
                                            <option value="a" >Administrador</option>
                                            <option value="g" selected>Gerente</option>
                                            <option value="e" >Encarregado</option>
                                            <option value="v" >Vendedor</option>  
                                        </c:if>
                                        <c:if test="${listaUsuarios.get(0).tipo eq 'e'}">
                                            <option value="a" >Administrador</option>
                                            <option value="g" >Gerente</option>
                                            <option value="e" selected>Encarregado</option>
                                            <option value="v" >Vendedor</option>  
                                        </c:if>
                                        <c:if test="${listaUsuarios.get(0).tipo eq 'v'}">
                                            <option value="a" >Administrador</option>
                                            <option value="g" >Gerente</option>
                                            <option value="e" >Encarregado</option>
                                            <option value="v" selected>Vendedor</option>  
                                        </c:if>

                                    </select>
                                </div>
                            </div>
                            <div class="row">

                                <div class="col-sm-4 form-group">
                                    <label>Defina uma Senha</label>
                                    <input type="password" placeholder="Entre com sua nova senha aqui.." class="form-control" name="senhaUsuario" value="${listaUsuarios.get(0).senha}">
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
