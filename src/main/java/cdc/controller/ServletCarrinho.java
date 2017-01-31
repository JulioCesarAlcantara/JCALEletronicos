/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import cdc.model.Carrinho;
import cdc.model.CarrinhoDAO;
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

            if (!idUsuario.isEmpty() && !cmd.equalsIgnoreCase("del")) {

                List<Carrinho> listaDeProdutosNoCarrinho = new ArrayList<Carrinho>();
                CarrinhoDAO carrinho = new CarrinhoDAO();
                listaDeProdutosNoCarrinho = carrinho.listaIntensDoCarrinho(idUsuario);
                List total = carrinho.precoTotalItensDoCarrinho(idUsuario);
                request.setAttribute("total", total);

                System.out.println("lista de produtos do carrinho: " + listaDeProdutosNoCarrinho);

                request.setAttribute("listaDeProdutosNoCarrinho", listaDeProdutosNoCarrinho);
                request.getRequestDispatcher("/Carrinho.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("del")) {
                String id = request.getParameter("idProduto");
                CarrinhoDAO carrinho = new CarrinhoDAO();
                carrinho.excluirItemDoCarrinho(id);
                response.sendRedirect("Carrinho?");
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("/LoginDeUsuarios.jsp").forward(request, response);
            Logger.getLogger(ServletTelaDeProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
