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
public class PromocaoProdutoDAO implements DAO {

    private Connection conn;

    public PromocaoProdutoDAO() throws Exception {
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
        PromocaoProduto PromoPro = (PromocaoProduto) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (PromoPro == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "INSERT INTO ProdutoPromocao (idProdutoPromocaoProduto, idPromocaoPromocaoProduto) VALUES (?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, PromoPro.getIdProdutoPromocaoProduto());
            ps.setInt(2, PromoPro.getIdPromocaoPromocaoProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir promoção de um produto:\n" + e);
        }
    }

    public List buscaProdutosParaComboDePromocao() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM Produto");
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<>();
            while (rs.next()) {
                Integer idProduto = rs.getInt(1);
                String nomeProduto = rs.getString(2);
                float precoProduto = rs.getFloat(3);
                String descricaoProduto = rs.getString(4);
                String categoriaProduto = rs.getString(5);
                int quantidadeProduto = rs.getInt(6);
                list.add(new Produto(idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeProduto));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        }
    }

    public List buscaPromocoesParaCombo() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM Promocao");
            rs = ps.executeQuery();
            List<Promocao> list = new ArrayList<>();
            
            while (rs.next()) {
                Integer idPromocao = rs.getInt(1);
                String nomePromocao = rs.getString(2);
                Date dataInicioPromocao = rs.getDate(3);
                Date dataFimPromocao = rs.getDate(4);
                float descontoPromocao = rs.getFloat(5);
                String statusPromocao = rs.getString(6);
                list.add(new Promocao(idPromocao, nomePromocao, dataInicioPromocao, dataFimPromocao, descontoPromocao, statusPromocao));
            }
            return list;
            
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }

    }

    public List buscaProdutosDeUmaPromocao(int idPromo) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT idProduto, nomeProduto FROM PromocaoProduto INNER JOIN Promocao ON Promocao.idPromocao = PromocaoProduto.idPromocaoPromocaoProduto INNER JOIN Produto ON idProduto = idProdutoPromocaoProduto AND idPromocao = ?");
            ps.setInt(1, idPromo);
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<>();
            while (rs.next()) {
                Integer idProduto = rs.getInt(1);
                String nomeProduto = rs.getString(2);
                list.add(new Produto(idProduto, nomeProduto, 0, null, null, 0));
            }

            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }
    }

    public void delete(Integer idProduto, Integer idPromocao) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        if (idProduto == 0 && idPromocao == 0) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "DELETE FROM PromocaoProduto WHERE idProdutoPromocaoProduto = ? AND idPromocaoPromocaoProduto = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, idProduto);
            ps.setInt(2, idPromocao);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao excluir dados da promoção: " + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluirPromo(int idProduto) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        if (idProduto == 0) {
            throw new Exception("O valor passado não pode ser nulo.");
        }

        try {
            String sql = "DELETE FROM PromocaoProduto WHERE idProdutoPromocaoProduto = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProduto);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }
}
