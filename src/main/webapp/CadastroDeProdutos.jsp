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
        <title> Cadasto de Produtos</title>
        <script>
            //Convertendo a imagem 1 em texto base 64;
            function convertImagemEmTexto1(evento) {
                var fr = new FileReader();
                fr.onload = function () {
                    document.getElementById("imagem1").value = fr.result;
                };
                fr.readAsDataURL((evento.target || window.event.srcElement).files[0]);
            }
            //Convertendo a imagem 2 em texto base 64;
            function convertImagemEmTexto2(evento) {
                var fr = new FileReader();
                fr.onload = function () {
                    document.getElementById("imagem2").value = fr.result;
                };
                fr.readAsDataURL((evento.target || window.event.srcElement).files[0]);
            }
            //Convertendo a imagem 3 em texto base 64;
            function convertImagemEmTexto3(evento) {
                var fr = new FileReader();
                fr.onload = function () {
                    document.getElementById("imagem3").value = fr.result;
                };
                fr.readAsDataURL((evento.target || window.event.srcElement).files[0]);
            }
        </script>
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
            <h1 class="well">Cadastro de Produtos</h1>
            <div class="col-lg-12 well">
                <div class="row">
                    <form action="cadPro" method="post">
                        <input type="hidden" name="cmd" value="saveAdd"/>
                        <input type="hidden" name="imgPro1" id="imagem1"/>
                        <input type="hidden" name="imgPro2" id="imagem2"/>
                        <input type="hidden" name="imgPro3" id="imagem3"/>
                        <div class="col-sm-12">
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Nome do produto</label>
                                    <input type="text" placeholder="Entre com o nome aqui .." required class="form-control" name="nome">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-12">
                                    <label> Descrição</label>
                                    <textarea placeholder="Entre com a descrição aqui.." rows="3" required name="descricao" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>Preço</label>
                                    <input type="number" placeholder="Entre com preço aqui.." required class="form-control" name="preco">
                                </div>	                  	
                                <div class="col-sm-4 form-group">
                                    <label>Categoria</label>
                                    <select name="categoria" required class="form-control selectpicker" >
                                        <option value="-1">Escolha a categoria do produto</option>
                                        <option value="ap">Aparelho</option>
                                        <option value="ac">Acessórios</option>
                                    </select>
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>Quantidade</label>
                                    <input type="number" placeholder="Quantidade deste produto.." required class="form-control" name="quantidade">
                                </div>
                            </div>	
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>1ª Imagem p/ Produto</label>
                                    <input type="file" class="form-control" id="imagem1" required onchange="convertImagemEmTexto1(this)">
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>2ª Imagem p/ Produto</label>
                                    <input type="file" class="form-control" id="imagem2" onchange="convertImagemEmTexto2(this)">
                                </div>	
                                <div class="col-sm-4 form-group">
                                    <label>3ª Imagem p/ Produto</label>
                                    <input type="file" class="form-control"id="imagem3"onchange="convertImagemEmTexto3(this)">
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
