package cdc.controller;

import cdc.model.CarrinhoDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServletItensDoCarrinho extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        try {

            String idProduto = request.getParameter("idPro");
            String idUsuario = session.getAttribute("idLoginUsuario").toString();

            if (!idUsuario.isEmpty()) {
                CarrinhoDAO itensDoCarrinho = new CarrinhoDAO();
                itensDoCarrinho.salvarProdutoNoCarrinho(idProduto, idUsuario);
                request.getRequestDispatcher("/TelaDeProdutos.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/LoginDeUsuarios.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            request.getRequestDispatcher("/LoginDeUsuarios.jsp").forward(request, response);
            Logger.getLogger(ServletTelaDeProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
