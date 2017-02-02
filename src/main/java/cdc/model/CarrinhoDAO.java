package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO implements DAO {

    Connection conn;

    public CarrinhoDAO() {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Carrinho ic = (Carrinho) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (ic == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "DELETE FROM ItemCompra WHERE idCarrinho = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ic.getIdCarrinho());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public List listaTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List procura(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void salvarProdutoNoCarrinho(String idPro, String idUsu) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        if (idPro == null || idUsu == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }

        try {
            String sql = "INSERT INTO Carrinho (idProdutoCarrinho, idUsuarioCarrinho) VALUES (?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, idPro);
            ps.setString(2, idUsu);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public List listaIntensDoCarrinho(String idUsu) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * "
                    + "FROM  Carrinho "
                    + "INNER JOIN Produto "
                    + "ON (Carrinho.idProdutoCarrinho = Produto.idProduto) "
                    + "INNER JOIN ImagemProduto "
                    + "ON (ImagemProduto.idProdutoImagemProduto = Produto.idProduto) "
                    + "WHERE Carrinho.idUsuarioCarrinho= '" + idUsu + "'"
                    + "ORDER BY `Carrinho`.`idCarrinho` ASC");

            System.out.println("SQL : " + ps);
            rs = ps.executeQuery();

            List lista = new ArrayList();
            while (rs.next()) {
                lista.add(new Carrinho(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getFloat(6), rs.getString(7),
                        rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getInt(14)));
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void excluirPromo(int id) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        if (id == 0) {
            throw new Exception("O valor passado não pode ser nulo!");
        }

        try {
            String sql = "DELETE FROM ItemCompra WHERE idProdutoItemCompra = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println(ps);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void excluirItemDoCarrinho(String idItemCompra) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        if (idItemCompra == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "DELETE FROM Carrinho WHERE idProdutoCarrinho = '" + idItemCompra + "'";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public float precoTotalItensDoCarrinho(String idUsuario) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;

            ps = conn.prepareStatement("SELECT SUM(Produto.precoProduto) FROM Carrinho INNER JOIN Produto "
                    + "ON (Carrinho.idProdutoCarrinho = Produto.idProduto) INNER JOIN ImagemProduto "
                    + "ON (ImagemProduto.idProdutoImagemProduto = Produto.idProduto) "
                    + "WHERE Carrinho.idUsuarioCarrinho= " + idUsuario);

            rs = ps.executeQuery();
            float preco = 0;
            while (rs.next()) {
                preco = rs.getInt(1);
            }
            return preco;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

}
