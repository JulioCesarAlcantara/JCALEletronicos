/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import cdc.model.UsuarioDAO;
import cdc.util.DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cesar
 */
public class ServletLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String cmd = request.getParameter("cmd");
        DAO dao;
        request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));

        if (cmd == null) {
            cmd = "principal";
        }

        try {
            UsuarioDAO usu = new UsuarioDAO();
            RequestDispatcher rd = null;
            if (cmd.equalsIgnoreCase("login")) {
                
                String email = request.getParameter("userEmail");
                String senha = request.getParameter("userPassword");
                boolean resultado = usu.verificaLoginUsuario(email, senha);

                if (resultado) {
                    HttpSession session = request.getSession();
                    //Determinando o tempo da sessão;
                    session.setMaxInactiveInterval(180);
                    
                    UsuarioDAO usuario = new UsuarioDAO();
                    String idLoginUsuario = Integer.toString(usuario.buscaIdUsuarioPeloLogin(email));

                    session.setAttribute("idLoginUsuario", idLoginUsuario);

                    rd = request.getRequestDispatcher("/TelaDeProdutos.jsp");

                } else {
                    getServletContext().getRequestDispatcher("/CadastroClientes.jsp").forward(request, response);
                }
                getServletContext().getRequestDispatcher("/TelaDeProdutos.jsp").forward(request, response);

            } else {
                rd = request.getRequestDispatcher("/index.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
