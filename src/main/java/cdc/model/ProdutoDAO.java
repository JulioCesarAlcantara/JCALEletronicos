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
        Produto pro = (Produto) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (pro == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }

        try {
            String sql = "update Produto set nomeProduto = ?, precoProduto = ?, descricaoProduto=?, categoriaProduto = ?, quantidadeEstoqueProduto=? where idProduto = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, pro.getNomeProduto());
            ps.setFloat(2, pro.getPrecoProduto());
            ps.setString(3, pro.getDescricaoProduto());
            ps.setString(4, pro.getCategoriaProduto());
            ps.setInt(5, pro.getQuantidadeEstoqueProduto());
            ps.setInt(6, pro.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        }
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
            String sql = "DELETE FROM PromocaoProduto WHERE idProdutoPromocaoProduto = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, com.getIdProduto());
            ps.executeUpdate();

            sql = "delete from ImagemProduto where idProdutoImagemProduto = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, com.getIdProduto());
            ps.executeUpdate();

            sql = "delete from Carrinho where idProdutoCarrinho = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, com.getIdProduto());
            ps.executeUpdate();

            sql = "DELETE FROM Produto WHERE idProduto = ?";
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
                    + " ON ImagemProduto.idProdutoImagemProduto = Produto.idProduto");
            rs = ps.executeQuery();
            List<MostraProdutoImagem> lista = new ArrayList<MostraProdutoImagem>();
            while (rs.next()) {
                lista.add(new MostraProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
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
       Produto com = (Produto) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (com == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            String SQL = "select * from Produto ";
            String where = "";
            boolean checa = false;
            if (com.getIdProduto() != 0) {
                where = "where ";
                if (com.getIdProduto() != 0) {
                    where += "idProduto=? ";
                    checa = true;
                }
            }

            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (com.getIdProduto() != 0) {
                if (com.getIdProduto() != 0) {
                    ps.setInt(contaCampos, com.getIdProduto());
                    contaCampos++;
                }
            }
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<Produto>();
            while (rs.next()) {
                Integer idProduto = rs.getInt(1);
                String nomeProduto = rs.getString(2);
                Float precoProduto = rs.getFloat(3);
                String descricaoProduto = rs.getString(4);
                String categoriaProduto = rs.getString(5);
                int quantidadeProduto = rs.getInt(6);
                
                list.add(new Produto(idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeProduto));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }
    }

    @Override
    public void salvar(Object ob) throws Exception {
        Produto pro = (Produto) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (pro == null) {
            throw new Exception("O valor passado não pode ser nulo.");
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
                    + "	INNER JOIN ImagemProduto"
                    + " ON ImagemProduto.idProdutoImagemProduto = Produto.idProduto "
                    + " WHERE Produto.nomeProduto "
                    + " LIKE '%" + str + "%'";

            conn = this.conn;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<MostraProdutoImagem> list = new ArrayList<MostraProdutoImagem>();
            while (rs.next()) {
                list.add(new MostraProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
    
    public List buscaListaDeAparelhosPesquisados(String str) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT Produto.idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeEstoqueProduto,"
                    + " idImagemProduto, imagem1,ImagemProduto.idProdutoImagemProduto"
                    + " FROM Produto"
                    + "	INNER JOIN ImagemProduto"
                    + " ON ImagemProduto.idProdutoImagemProduto = Produto.idProduto "
                    + " WHERE Produto.nomeProduto "
                    + " LIKE '%" + str + "%'"
                    + " AND Produto.categoriaProduto = 'ap'";

            conn = this.conn;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<MostraProdutoImagem> list = new ArrayList<MostraProdutoImagem>();
            while (rs.next()) {
                list.add(new MostraProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
    
    public List buscaListaDeAcessoriosPesquisados(String str) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT Produto.idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeEstoqueProduto,"
                    + " idImagemProduto, imagem1,ImagemProduto.idProdutoImagemProduto"
                    + " FROM Produto"
                    + "	INNER JOIN ImagemProduto"
                    + " ON ImagemProduto.idProdutoImagemProduto = Produto.idProduto "
                    + " WHERE Produto.nomeProduto "
                    + " LIKE '%" + str + "%'"
                    + " AND Produto.categoriaProduto = 'ac'";

            conn = this.conn;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<MostraProdutoImagem> list = new ArrayList<MostraProdutoImagem>();
            while (rs.next()) {
                list.add(new MostraProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
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
                lista.add(new MostraProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4),
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

    public int buscaIdDoProdutoPeloNome(String str) throws Exception {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String sql = "SELECT idProduto FROM Produto WHERE nomeProduto= '" + str + "'";

            conn = this.conn;
            ps = conn.prepareStatement(sql);

            rs = (ResultSet) ps.executeQuery();
            int id = 0;

            while (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }
    
    public List listaTodosAcessorios() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT Produto.idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeEstoqueProduto,"
                    + " idImagemProduto, imagem1,ImagemProduto.idProdutoImagemProduto"
                    + " FROM Produto"
                    + "	INNER JOIN ImagemProduto"
                    + " ON ImagemProduto.idProdutoImagemProduto = Produto.idProduto"
                    + " WHERE categoriaProduto = 'ac'");
            rs = ps.executeQuery();
            List<MostraProdutoImagem> lista = new ArrayList<MostraProdutoImagem>();
            while (rs.next()) {
                lista.add(new MostraProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
    
    public List listaTodosAparelhos() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT Produto.idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeEstoqueProduto,"
                    + " idImagemProduto, imagem1,ImagemProduto.idProdutoImagemProduto"
                    + " FROM Produto"
                    + "	INNER JOIN ImagemProduto"
                    + " ON ImagemProduto.idProdutoImagemProduto = Produto.idProduto"
                    + " WHERE categoriaProduto = 'ap'");
            rs = ps.executeQuery();
            List<MostraProdutoImagem> lista = new ArrayList<MostraProdutoImagem>();
            while (rs.next()) {
                lista.add(new MostraProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
    
    public List buscaDadosDoProdutoDeUmaPromocao(int id) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT Produto.idProduto, nomeProduto, precoProduto, descricaoProduto, categoriaProduto, quantidadeEstoqueProduto, idImagemProduto, imagem1,ImagemProduto.idProdutoImagemProduto FROM PromocaoProduto INNER JOIN Produto ON idProduto = idProdutoPromocaoProduto INNER JOIN ImagemProduto ON ImagemProduto.idProdutoImagemProduto = Produto.idProduto INNER JOIN Promocao ON Promocao.idPromocao = PromocaoProduto.idPromocaoPromocaoProduto AND idPromocao ="+id);
            rs = ps.executeQuery();
            List<MostraProdutoImagem> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new MostraProdutoImagem(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

}
