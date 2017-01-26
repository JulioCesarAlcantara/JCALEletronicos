/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import cdc.model.Cliente;
import cdc.model.ClienteDAO;
import cdc.model.Usuario;
import cdc.model.UsuarioDAO;
import cdc.util.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletClientes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cmd = request.getParameter("cmd");
        DAO dao;

        request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));
        //stando o valor default do cmd
        if (cmd == null) {
            cmd = "principal";
        }

        try {
            dao = new ClienteDAO();
            RequestDispatcher rd = null; 
            if (cmd.equalsIgnoreCase("saveAdd")) {
                String primeiroNomeCliente = request.getParameter("primeiroNomeCliente");
                String segundoNomeCliente = request.getParameter("segundoNomeCliente");
                String telefoneCliente = request.getParameter("telefoneCliente");
                String emailCliente = request.getParameter("emailCliente");
                String dataNascimentoCliente = request.getParameter("dataNascimentoCliente");
                String sexoCliente = request.getParameter("sexoCliente");
                String senhaCliente = request.getParameter("senhaCliente");
                String enderecoCliente = request.getParameter("enderecoCliente");
                String cidadeCliente = request.getParameter("cidadeCliente");
                String estadoCliente = request.getParameter("estadoCliente");
                String cepCliente = request.getParameter("cepCliente");
                String cpfCliente = request.getParameter("cpfCliente");

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(dataNascimentoCliente).getTime());

                Cliente cliente = new Cliente(primeiroNomeCliente+" "+segundoNomeCliente, emailCliente, telefoneCliente, data, sexoCliente,"c", senhaCliente, cpfCliente, enderecoCliente, cepCliente, cidadeCliente, estadoCliente);
                dao.salvar(cliente);
                //getServletContext().getRequestDispatcher("/TelaPrincipal.jsp").forward(request, response);
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
