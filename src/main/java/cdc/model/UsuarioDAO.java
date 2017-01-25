package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
       Usuario usua = (Usuario) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (usua == null) {
            throw new Exception("O valor passado não pode ser nulo/ The value passed cannot be null");
        }

        try {
            String sql = "INSERT INTO Usuario (nomeUsuario, emailUsuario, telefoneUsuario, "
                    + "dataNascimentoUsuario, sexoUsuario, tipoUsuario,  passwordUsuario, "
                    + "cpfUsuario, enderecoUsuario, cepUsuario, cidadeUsuario, estadoUsuario) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, usua.getNome());
            ps.setString(2, usua.getEmail());
            ps.setString(3, usua.getTelefone());
            ps.setDate(4, usua.getDataNascimento());
            ps.setString(5, usua.getSexo());
            ps.setString(6, usua.getTipo());
            ps.setString(7, usua.getSenha());
            ps.setString(8, usua.getCpf());
            ps.setString(9, usua.getEndereco());
            ps.setString(10, usua.getCep());
            ps.setString(11, usua.getCidade());
            ps.setString(12, usua.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }
    
    /**
     * Este método verifica se o login e senha do usuário existem. Caso exista, o
     * servlet inicia a sessão, caso não, ele redireciona pro login; 
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
            String sql = "SELECT tipoUsuario FROM Usuario WHERE emailUsuario = ? AND passwordUsuario = ?";
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
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

}
