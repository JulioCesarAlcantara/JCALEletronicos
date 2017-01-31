package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements DAO {

    Connection conn;

    public UsuarioDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        Usuario usua = (Usuario) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (usua == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "UPDATE  Usuario SET primeiroNomeUsuario=?, segundoNomeUsuario=?, emailUsuario=?, telefoneUsuario=?, "
                    + "dataNascimentoUsuario=?, sexoUsuario=?, tipoUsuario=?,  senhaUsuario=? WHERE idUsuario = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, usua.getPrimeiroNome());
            ps.setString(2, usua.getSegundoNome());
            ps.setString(3, usua.getEmail());
            ps.setString(4, usua.getTelefone());
            ps.setDate(5, usua.getDataNascimento());
            ps.setString(6, usua.getSexo());
            ps.setString(7, usua.getTipo());
            ps.setString(8, usua.getSenha());
            ps.setInt(9, usua.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

    }

    @Override
    public void excluir(Object ob) throws Exception {
        Usuario usu = (Usuario) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (usu == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "delete from Usuario where idUsuario = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, usu.getId());
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
            ps = conn.prepareStatement("select * from Usuario where tipoUsuario <> 'c'");
            rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<Usuario>();
            while (rs.next()) {
                list.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public List procura(Object ob) throws Exception {
        Usuario usu = (Usuario) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from Usuario where idUsuario = ?");
            ps.setInt(1, usu.getId());
            rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<Usuario>();
            while (rs.next()) {
                list.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
        Usuario usua = (Usuario) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (usua == null) {
            throw new Exception("O valor passado não pode ser nulo/ The value passed cannot be null");
        }

        try {
            String sql = "INSERT INTO Usuario (primeiroNomeUsuario, segundoNomeUsuario, emailUsuario, telefoneUsuario, "
                    + "dataNascimentoUsuario, sexoUsuario, tipoUsuario,  senhaUsuario) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, usua.getPrimeiroNome());
            ps.setString(2, usua.getSegundoNome());
            ps.setString(3, usua.getEmail());
            ps.setString(4, usua.getTelefone());
            ps.setDate(5, usua.getDataNascimento());
            ps.setString(6, usua.getSexo());
            ps.setString(7, usua.getTipo());
            ps.setString(8, usua.getSenha());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    /**
     * Este método verifica se o login e senha do usuário existem. Caso exista,
     * o servlet inicia a sessão, caso não, ele redireciona pro login;
     *
     * @param email do usuário login;
     * @param senha do usuário;
     * @return true se existir ou false se não existir;
     * @throws Exception
     */
    public boolean verificaLoginUsuario(String email, String senha) throws Exception {
        String username = email;
        String password = senha;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT tipoUsuario FROM Usuario WHERE emailUsuario = ? AND senhaUsuario = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs.last();
            int size = rs.getRow();
            rs.beforeFirst();

            return size >= 1;

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    /**
     * Este método busca o id do usuário pelo login para realizar a persistência
     * no bd na tabelas de produto.
     *
     * @param loginUsuario do usuário;
     * @return Integer com o valor do id do Usuario;
     * @throws Exception
     */
    public Integer buscaIdUsuarioPeloLogin(String loginUsuario) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT idUsuario "
                    + "FROM `Usuario` "
                    + "WHERE emailUsuario = '" + loginUsuario + "'");

            rs = ps.executeQuery();
            Integer idUsuario = 0;
            while (rs.next()) {
                idUsuario = rs.getInt(1);
            }

            return idUsuario;
        } catch (SQLException e) {
            throw new Exception(e);
        } 
    }
    
    public String buscaTipoDoUsuarioPeloId(String idUsuario)throws Exception {
    PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT tipoUsuario FROM `Usuario` WHERE idUsuario= '"+idUsuario+"'");

            rs = ps.executeQuery();
            String tipo = null;
            while (rs.next()) {
                tipo = rs.getString(1);
            }

            return tipo;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

}
