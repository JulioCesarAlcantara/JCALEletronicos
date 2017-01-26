package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ImagemProdutoDAO implements DAO {

    Connection conn;

    public ImagemProdutoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        ImagemProduto imagemProdutp = (ImagemProduto) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (imagemProdutp == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }

        try {
            String sql = "UPDATE ImagemProduto ImagemDeProduto SET imagem1=?,imagem2=?,imagem3=?) WHERE idProduto = ?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, imagemProdutp.getImagem1());
            ps.setString(2, imagemProdutp.getImagem2());
            ps.setString(3, imagemProdutp.getImagem3());
            ps.setInt(4, imagemProdutp.getIdProdutoImagemProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ImagemProduto ip = (ImagemProduto) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (ip == null) {
            throw new Exception("O valor passado não pode ser nulo/ The value passed cannot be null");
        }

        try {
            String sql = "INSERT INTO ImagemProduto (imagem1,imagem2,imagem3,idProdutoImagemProduto) VALUES (?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, ip.getImagem1());
            ps.setString(2, ip.getImagem2());
            ps.setString(3, ip.getImagem3());
            ps.setInt(4, ip.getIdProdutoImagemProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluirPromo(int id) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        if (id == 0) {
            throw new Exception("O valor passado não pode ser nulo!");
        }

        try {
            String sql = "delete from ImagemDeProduto where idProduto = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

}
