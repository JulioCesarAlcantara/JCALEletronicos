package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements DAO {

    Connection conn;

    public ProdutoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Produto com = (Produto) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }

        try {
            String sql = "DELETE FROM Produto WHERE idProduto = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, com.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public List listaTodos() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT Produto.idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeEstoqueProduto,"
                    + " idImagemProduto, imagem1,ImagemProduto.idProdutoImagemProduto"
                    + " FROM Produto"
                    + "	INNER JOIN ImagemProduto"
                    + " ON ImagemProduto.idProduto = Produto.idProduto");
            rs = ps.executeQuery();
            List<ProdutoImagem> lista = new ArrayList<ProdutoImagem>();
            while (rs.next()) {
                lista.add(new ProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public List procura(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        Produto pro = (Produto) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (pro == null) {
            throw new Exception("O valor passado não pode ser nulo/ The value passed cannot be null");
        }

        try {
            String sql = "INSERT INTO Produto (nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeEstoqueProduto) values (?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, pro.getNomeProduto());
            ps.setFloat(2, pro.getPrecoProduto());
            ps.setString(3, pro.getDescricaoProduto());
            ps.setString(4, pro.getCategoriaProduto());
            ps.setInt(5, pro.getQuantidadeEstoqueProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }
    
    public List buscaListaDeProdutosPesquisados(String str) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT Produto.idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeEstoqueProduto,"
                    + " idImagemProduto, imagem1,ImagemProduto.idProdutoImagemProduto"
                    + " FROM Produto"
                    + "	INNER JOIN ImagemDeProduto"
                    + " ON ImagemProduto.idProdutoImagemProduto = Produto.idProduto "
                    + " WHERE Produto.nomeProduto "
                    + " LIKE '%" + str + "%'";

            conn = this.conn;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<ProdutoImagem> list = new ArrayList<ProdutoImagem>();
            while (rs.next()) {
                list.add(new ProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public List listaProdutosParaCompra(String id) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT *  "
                    + "FROM Produto "
                    + "INNER JOIN ImagemProduto  "
                    + "ON ImagemProduto.idProdutoImagemProduto = Produto.idProduto "
                    + "WHERE Produto.idProduto = " + id);

            System.out.println("SQL : " + ps);
            rs = ps.executeQuery();

            List lista = new ArrayList();
            while (rs.next()) {
                lista.add(new ProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public List pegaProdutos() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * from Produto");
            rs = ps.executeQuery();

            List lista = new ArrayList();
            while (rs.next()) {
                lista.add(new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

}
