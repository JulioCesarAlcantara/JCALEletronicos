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
        <title> Cadasto de Usuários</title>
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
            <h1 class="well">Cadastro de Usuários</h1>
            <div class="col-lg-12 well">
                <div class="row">
                    <form>
                        <div class="col-sm-12">
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Primeiro Nome</label>
                                    <input type="text" placeholder="Entre com 1º nome aqui .." class="form-control">
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label>Segundo Nome</label>
                                    <input type="text" placeholder="Entre com 2º nome aqui .." class="form-control">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Telefone</label>
                                    <input type="text" placeholder="Entre com Telefone aqui.." class="form-control">
                                </div>		
                                <div class="col-sm-6 form-group">
                                    <label>Email</label>
                                    <input type="text" placeholder="Entre com Email aqui.." class="form-control">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>Data de Nascimento</label>
                                    <input type="date" class="form-control">
                                </div>		
                                <div class="col-sm-4 form-group">
                                    <label>Sexo</label>
                                    <select name="sexo" class="form-control selectpicker" >
                                        <option value="-1" >Escolha seu sexo</option>
                                        <option value="masculino" >Masculino</option>
                                        <option value="feminino" >Feminino</option>
                                    </select>
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>CPF</label>
                                    <input type="text" placeholder="Cadastro de Pessoa Física aqui.." class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Endereço</label>
                                <textarea placeholder="Entre com o Endereço aqui.." rows="3" class="form-control"></textarea>
                            </div>	
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>Cidade</label>
                                    <input type="text" placeholder="Entre com o nome da cidade aqui.." class="form-control">
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>Estado</label>
                                    <input type="text" placeholder="Entre com o Estado aqui.." class="form-control">
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>CEP</label>
                                    <input type="text" placeholder="Entre com o CEP aqui.." class="form-control">
                                </div>		
                            </div>
                            
                            <input type="submit" class="btn btn-lg btn-success" value="Cadastrar">
                        </div>
                    </form> 
                </div>
            </div>
        </div>
    </body>
</html>