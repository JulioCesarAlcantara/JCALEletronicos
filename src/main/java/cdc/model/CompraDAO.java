package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CompraDAO implements DAO {

    Connection conn;

    public CompraDAO() throws Exception {
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
        Compra com = (Compra) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }

        try {
            String sql = "INSERT INTO Compra (valorCompra, freteCompra, idUsuarioCompra) values (?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, com.getValor());
            ps.setFloat(2, com.getFrete());
            ps.setInt(3, com.getIdUsuarioCompra());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}
