/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import cdc.model.Carrinho;
import cdc.model.CarrinhoDAO;
import cdc.model.Cliente;
import cdc.model.ClienteDAO;
import cdc.model.Compra;
import cdc.model.CompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cesar
 */
//@WebServlet(name = "ServletCarrinho", urlPatterns = {"/ServletCarrinho"})
public class ServletCarrinho extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String cmd = request.getParameter("cmd");

        if (cmd == null) {
            cmd = "principal";
        }

        try {

            String idUsuario = session.getAttribute("idLoginUsuario").toString();
            System.out.println("========" + idUsuario);

            if (!idUsuario.isEmpty() && !cmd.equalsIgnoreCase("del") && !cmd.equalsIgnoreCase("finalizaCompra")) {

                List<Carrinho> listaDeProdutosNoCarrinho = new ArrayList<Carrinho>();
                CarrinhoDAO carrinho = new CarrinhoDAO();
                listaDeProdutosNoCarrinho = carrinho.listaIntensDoCarrinho(idUsuario);
               float total = carrinho.precoTotalItensDoCarrinho(idUsuario);
                
                request.setAttribute("total", total);
                
                System.out.println("lista de produtos do carrinho: " + listaDeProdutosNoCarrinho);

                request.setAttribute("listaDeProdutosNoCarrinho", listaDeProdutosNoCarrinho);
                request.getRequestDispatcher("/Carrinho.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("del")) {
                String id = request.getParameter("idProduto");
                CarrinhoDAO carrinho = new CarrinhoDAO();
                carrinho.excluirItemDoCarrinho(id);
                response.sendRedirect("Carrinho?");
            } else if (cmd.equalsIgnoreCase("finalizaCompra")){
                CompraDAO compraDAO = new CompraDAO();
                Compra compra = new Compra();
                Integer id = Integer.parseInt(request.getParameter("idUsua"));
                Float valor = Float.parseFloat(request.getParameter("total"));
                ClienteDAO a = new ClienteDAO();
                Cliente b = new Cliente();
                b.setIdCliente(id);
                List<Cliente> dadosDoCliente = a.procura(b);
                Cliente clienteModel = new Cliente();

                for (Cliente cliente : dadosDoCliente) {
                    clienteModel.setPrimeiroNomeCliente(cliente.getPrimeiroNomeCliente());
                    clienteModel.setSegundoNomeCliente(cliente.getSegundoNomeCliente());
                    clienteModel.setCepCliente(cliente.getCepCliente());
                    clienteModel.setCidadeCliente(cliente.getCidadeCliente());
                    clienteModel.setEstadoCliente(cliente.getEstadoCliente());
                    clienteModel.setEnderecoCliente(cliente.getEnderecoCliente());
                    clienteModel.setCpfCliente(cliente.getCpfCliente());
                }

//                Date date = null;
//                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year = 2017;
                int month = 03;
                int day = 02;

                Datas datas = Datas.novasDatas()
                        .comDocumento(day, month, year)
                        .comProcessamento(day, month, year)
                        .comVencimento(day + 10, month, year);

                Endereco enderecoBeneficiario = Endereco.novoEndereco()
                        .comLogradouro("Smell Importados, 000")
                        .comBairro("Jardim Suiço")
                        .comCep("75400-000")
                        .comCidade("Inhumas")
                        .comUf("GO");

                //Quem emite o boleto
                Beneficiario beneficiario = Beneficiario.novoBeneficiario()
                        .comNomeBeneficiario("Julio Cesar Alcântara Lopes")
                        .comAgencia("0496").comDigitoAgencia("0")
                        .comCodigoBeneficiario("35441")
                        .comDigitoCodigoBeneficiario("4")
                        .comNumeroConvenio("1207113")
                        .comCarteira("18")
                        .comEndereco(enderecoBeneficiario)
                        .comNossoNumero("92606360");

                Endereco enderecoPagador = Endereco.novoEndereco()
                        .comLogradouro(clienteModel.getEnderecoCliente())
                        .comBairro("Bairro")
                        .comCep(clienteModel.getCepCliente())
                        .comCidade(clienteModel.getCidadeCliente())
                        .comUf(clienteModel.getEstadoCliente());

                //Quem paga o boleto
                Pagador pagador = Pagador.novoPagador()
                        .comNome(clienteModel.getPrimeiroNomeCliente()+" "+clienteModel.getSegundoNomeCliente())
                        .comDocumento(clienteModel.getCpfCliente())
                        .comEndereco(enderecoPagador);

                Banco banco = new BancoDoBrasil();

                Boleto boleto = Boleto.novoBoleto()
                        .comBanco(banco)
                        .comDatas(datas)
                        .comBeneficiario(beneficiario)
                        .comPagador(pagador)
                        .comValorBoleto(valor)
                        .comNumeroDoDocumento("1234")
                        .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")
                        .comLocaisDePagamento("local 1", "local 2");

                GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

                // Para gerar um boleto em PDF  
                gerador.geraPDF("/home/erik/BancoDoBrasil1asl2332.pdf");

                // Para gerar um boleto em PNG  
                gerador.geraPNG("/home/erik/BancoDoBrasil1223232.png");

                compra.setIdUsuarioCompra(id);
                compra.setValor(valor);
                compra.setFrete(4);
                System.out.println("===============ID: "+id);
                System.out.println("===============Valor: "+valor);
                compraDAO.salvar(compra);
//                 
                //request.getRequestDispatcher("/TelaPrincipal.jsp").forward(request, response);
            
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("/LoginDeUsuarios.jsp").forward(request, response);
            Logger.getLogger(ServletTelaDeProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
