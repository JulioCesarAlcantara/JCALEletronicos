package cdc.controller;

import cdc.model.Cliente;
import cdc.model.ClienteDAO;
import cdc.util.DAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletClientes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cmd = request.getParameter("cmd");
        DAO dao;

        if (cmd == null) {
            cmd = "principal";
        }

        try {
            dao = new ClienteDAO();
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

                Cliente cliente = new Cliente(primeiroNomeCliente, segundoNomeCliente, emailCliente, telefoneCliente, data, sexoCliente, "c", senhaCliente, cpfCliente, enderecoCliente, cepCliente, cidadeCliente, estadoCliente);
                dao.salvar(cliente);
                getServletContext().getRequestDispatcher("/LoginDeUsuarios.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("add")) {
                getServletContext().getRequestDispatcher("/CadastroClientes.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("listar")) {
                List listaClientes = dao.listaTodos();
                request.setAttribute("listaClientes", listaClientes);
                getServletContext().getRequestDispatcher("/listarClientes.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("del")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                Cliente cliente = new Cliente();
                cliente.setIdCliente(id);
                dao.excluir(cliente);
                getServletContext().getRequestDispatcher("/clientes?cmd=listar").forward(request, response);

            } else if (cmd.equalsIgnoreCase("update")) {
                Integer idCliente = Integer.parseInt(request.getParameter("id"));
                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                List listaClientes = dao.procura(cliente);
                request.setAttribute("listaClientes", listaClientes);
                getServletContext().getRequestDispatcher("/AlterarClientes.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("saveUpdate")) {
                Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
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

                Cliente cliente = new Cliente(idCliente, primeiroNomeCliente, segundoNomeCliente, emailCliente, telefoneCliente, data, sexoCliente, "c", senhaCliente, cpfCliente, enderecoCliente, cepCliente, cidadeCliente, estadoCliente);
                dao.atualizar(cliente);
                getServletContext().getRequestDispatcher("/clientes?cmd=listar").forward(request, response);

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
