package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class PromocaoDAO implements DAO {

    private Connection conn;

    public PromocaoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        Promocao promo = (Promocao) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (promo == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }
        
        try {
            String SQL = "UPDATE Promocao SET nomePromocao = ?, datacomecoPromocao = ?, dataFimPromocao = ?, descontoPromocao=?, statusPromocao=? WHERE idPromocao = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, promo.getNomePromocao());
            ps.setDate(2, promo.getDataComecoPromocao());
            ps.setDate(3, promo.getDataFimPromocao());
            ps.setFloat(4, promo.getDescontoPromocao());
            ps.setString(5, promo.getStatusPromocao());
            ps.setInt(6, promo.getIdPromocao());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar Promocao:\n" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Promocao promo = (Promocao) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (promo == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }
        
        try {
            String SQL = "DELETE FROM Promocao where idPromocao = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, promo.getIdPromocao());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Erro ao excluir Promocao:\n" + e);
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
            ps = conn.prepareStatement("select * from Promocao");
            rs = ps.executeQuery();
            List<Promocao> list = new ArrayList<Promocao>();
            
            //inserindo na lista;
            while (rs.next()) {
                Integer idPromocao = rs.getInt(1);
                String nomePromocao = rs.getString(2);
                Date dataInicio = rs.getDate(3);
                Date dataFim = rs.getDate(4);
                float descontoPromo = rs.getFloat(5);
                String statusPromo = rs.getString(6);
                list.add(new Promocao(idPromocao, nomePromocao, dataInicio, dataFim, descontoPromo, statusPromo));
            }
            
            return list;
            
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }
    }

    @Override
    public List procura(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        Promocao promo = (Promocao) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (promo == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }
        
        try {
            String SQL = "INSERT INTO Promocao (nomePromocao, dataInicioPromocao, dataFimPromocao, descontoPromocao, statusPromocao) VALUES (?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, promo.getNomePromocao());
            ps.setDate(2, promo.getDataComecoPromocao());
            ps.setDate(3, promo.getDataFimPromocao());
            ps.setFloat(4, promo.getDescontoPromocao());
            ps.setString(5, promo.getStatusPromocao());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir Promocao:\n" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}
