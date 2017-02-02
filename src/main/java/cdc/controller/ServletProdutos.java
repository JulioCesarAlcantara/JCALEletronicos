package cdc.controller;

import cdc.model.ImagemProduto;
import cdc.model.ImagemProdutoDAO;
import cdc.model.Produto;
import cdc.model.ProdutoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletProdutos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cmd = request.getParameter("cmd");

        request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));

        if (cmd == null) {
            cmd = "principal";
        }

        try {
            ImagemProdutoDAO imageDAO = new ImagemProdutoDAO();
            ProdutoDAO produto = new ProdutoDAO();

            if (cmd.equalsIgnoreCase("saveAdd")) {
                String nomeProduto = request.getParameter("nome");
                String descricaoProduto = request.getParameter("descricao");
                String precoProduto = request.getParameter("preco");
                //convertendo preço em float; 
                float preco = Float.parseFloat(precoProduto);

                String categoria = request.getParameter("categoria");
                String qntProduto = request.getParameter("quantidade");
                String imagem1 = request.getParameter("imgPro1");
                String imagem2 = request.getParameter("imgPro2");
                String imagem3 = request.getParameter("imgPro3");
                
                //convertendo a qntd do produto para int; 
                int quantidade = Integer.parseInt(qntProduto);

                Produto produtoMontado = new Produto(nomeProduto, preco, descricaoProduto, categoria, quantidade);
                produto.salvar(produtoMontado);

                //busca o id do produto add, para add imagem; 
                int idProduto = produto.buscaIdDoProdutoPeloNome(nomeProduto);
               
                ImagemProduto imgPro = new ImagemProduto(imagem1, imagem2, imagem3, idProduto);
                imageDAO.salvar(imgPro);
                getServletContext().getRequestDispatcher("/cadPro?cmd=listar").forward(request, response);

            } else if (cmd.equalsIgnoreCase("del")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                Produto prod = new Produto();
                prod.setIdProduto(id);
                produto.excluir(prod);
                getServletContext().getRequestDispatcher("/cadPro?cmd=listar").forward(request, response);

            } else if (cmd.equalsIgnoreCase("saveUpdate")) {
                Integer idProduto = Integer.parseInt(request.getParameter("id"));
                String nomeProduto = request.getParameter("nome");
                String descricaoProduto = request.getParameter("descricao");
                String precoProduto = request.getParameter("preco");
                
                //convertendo preço em float; 
                float preco = Float.parseFloat(precoProduto);
                String categoria = request.getParameter("categoria");
                String qntProduto = request.getParameter("quantidade");

                //convertendo a qntd do produto para int; 
                int quantidade = Integer.parseInt(qntProduto);

                Produto produtoMontado = new Produto(idProduto, nomeProduto, preco, descricaoProduto, categoria, quantidade);
                produto.atualizar(produtoMontado);
                getServletContext().getRequestDispatcher("/cadPro?cmd=listar").forward(request, response);

            } else if (cmd.equalsIgnoreCase("update")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                Produto prod = new Produto();
                prod.setIdProduto(id);
                List listaProdutos = produto.procura(prod);
                request.setAttribute("listaProdutos", listaProdutos);
                getServletContext().getRequestDispatcher("/AlterarProdutos.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("listar")) {
                List listaProdutos = produto.listaTodos();
                request.setAttribute("listaProdutos", listaProdutos);
                getServletContext().getRequestDispatcher("/listarProdutos.jsp").forward(request, response);

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
