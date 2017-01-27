package cdc.controller;

import cdc.model.MostraProdutoImagem;
import cdc.model.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTelaDeProdutos extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String idProduto = request.getParameter("idProduto");
            List<MostraProdutoImagem> ItensDeProdutos = new ArrayList<MostraProdutoImagem>();
            ProdutoDAO pro = new ProdutoDAO();

            ItensDeProdutos = pro.listaProdutosParaCompra(idProduto);
            request.setAttribute("ItensDeProdutos", ItensDeProdutos);
            request.getRequestDispatcher("/Carrinho.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ServletTelaDeProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
