
package cdc.controller;

import cdc.model.PromocaoProduto;
import cdc.model.PromocaoProdutoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAssociaProdutoPromocao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cmd = request.getParameter("cmd");
        PromocaoProdutoDAO dao;

        request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));
        if (cmd == null) {
            cmd = "principal";
        }

        try {
            dao = new PromocaoProdutoDAO();
            RequestDispatcher rd = null; 
            if (cmd.equalsIgnoreCase("saveAdd")) {
                Integer idPromocao = Integer.parseInt(request.getParameter("idPromo"));
                String[] idProduto = request.getParameterValues("idProd");
                Integer id;
                for (String produto : idProduto) {
                    id = Integer.parseInt(produto);
                    PromocaoProduto prodPromo = new PromocaoProduto(id, idPromocao);
                    dao.salvar(prodPromo);
                }   
                getServletContext().getRequestDispatcher("/AssociaProdutoNaPromocao.jsp").forward(request, response);
            } else if (cmd.equalsIgnoreCase("del")) {
                Integer idPromoProd = Integer.parseInt(request.getParameter("idPromocaoProduto"));                
                PromocaoProdutoDAO promoProd = new PromocaoProdutoDAO();
                PromocaoProduto prpr = new PromocaoProduto(idPromoProd);
                promoProd.excluir(prpr);
               getServletContext().getRequestDispatcher("/AssociaProdutoNaPromocao.jsp").forward(request, response);

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
