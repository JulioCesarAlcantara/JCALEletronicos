package cdc.controller;


import cdc.model.Usuario;
import cdc.model.UsuarioDAO;
import cdc.util.DAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUsuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cmd = request.getParameter("cmd");
        DAO dao;

        request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));
        //setando o valor default do cmd
        if (cmd == null) {
            cmd = "principal";
        }

        try {
            dao = new UsuarioDAO();
            RequestDispatcher rd = null; 
            if (cmd.equalsIgnoreCase("saveAdd")) {
                String primeiroNomeUsuario = request.getParameter("primeiroNomeUsuario");
                String segundoNomeUsuario = request.getParameter("segundoNomeUsuario");
                String telefoneUsuario = request.getParameter("telefoneUsuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String dataNascimentoUsuario = request.getParameter("dataNascimentoUsuario");
                String sexoUsuario = request.getParameter("sexoUsuario");
                String senhaUsuario = request.getParameter("senhaUsuario");
                String tipoUsuario = request.getParameter("tipoUsuario");

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(dataNascimentoUsuario).getTime());

                Usuario usuario = new Usuario(primeiroNomeUsuario, segundoNomeUsuario, emailUsuario, telefoneUsuario, data, sexoUsuario, tipoUsuario, senhaUsuario);
                dao.salvar(usuario);
                getServletContext().getRequestDispatcher("/usuarios?cmd=listar").forward(request, response);
            } else if (cmd.equalsIgnoreCase("listar")){
                List listaUsuarios = dao.listaTodos();
                request.setAttribute("listaUsuarios", listaUsuarios); 
                getServletContext().getRequestDispatcher("/listarUsuarios.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("update")) {
                Usuario usuario = new Usuario();
                Integer idUsuario = Integer.parseInt(request.getParameter("id"));
                usuario.setId(idUsuario);
                List<Usuario> listaUsuarios = dao.procura(usuario);
                for (Usuario u: listaUsuarios){
                    System.out.println(u.getSexo());
                }
                request.setAttribute("listaUsuarios", listaUsuarios);
                getServletContext().getRequestDispatcher("/AlterarUsuarios.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("saveUpdate")) {
                Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                String primeiroNomeUsuario = request.getParameter("primeiroNomeUsuario");
                String segundoNomeUsuario = request.getParameter("segundoNomeUsuario");
                String telefoneUsuario = request.getParameter("telefoneUsuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String dataNascimentoUsuario = request.getParameter("dataNascimentoUsuario");
                String sexoUsuario = request.getParameter("sexoUsuario");
                String senhaUsuario = request.getParameter("senhaUsuario");
                String tipoUsuario = request.getParameter("tipoUsuario");
                
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(dataNascimentoUsuario).getTime());

                Usuario usuario = new Usuario(idUsuario, primeiroNomeUsuario, segundoNomeUsuario, emailUsuario, telefoneUsuario, data, sexoUsuario, tipoUsuario, senhaUsuario);
                dao.atualizar(usuario);
                getServletContext().getRequestDispatcher("/usuarios?cmd=listar").forward(request, response);

            } else if (cmd.equalsIgnoreCase("add")) {
                getServletContext().getRequestDispatcher("/CadastroUsuarios.jsp").forward(request, response);
            } else if (cmd.equalsIgnoreCase("del")) {
                Integer idUsuario = Integer.parseInt(request.getParameter("id"));
                Usuario usuario = new Usuario();
                usuario.setId(idUsuario);
                dao.excluir(usuario);
                getServletContext().getRequestDispatcher("/usuarios?cmd=listar").forward(request, response);
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
