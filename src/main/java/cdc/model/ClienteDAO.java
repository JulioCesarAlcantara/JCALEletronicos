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
public class ClienteDAO implements DAO {

    private Connection conn = null;

    public ClienteDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:\n" + e.getMessage());
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        Cliente cliente = (Cliente) ob;
        PreparedStatement ps = null;
        Connection conn = ConnectionDAO.getConnection();

        if (cliente == null) {
            throw new Exception("O valor passado não pode ser nulo. Por favor informe valores.");
        }

        try {
            String query = "UPDATE Usuario set primeiroNomeUsuario=?, segundoNomeUsuario=?, emailUsuario=?, telefoneUsuario=?,  "
                    + "dataNascimentoUsuario=?, sexoUsuario=?, tipoUsuario=?, senhaUsuario=?, "
                    + "cpfUsuario=?, enderecoUsuario=?, cepUsuario=?,  cidadeUsuario=?, estadoUsuario=? WHERE idUsuario = ?";
            ps = conn.prepareStatement(query);

            ps.setString(1, cliente.getPrimeiroNomeCliente());
            ps.setString(2, cliente.getSegundoNomeCliente());
            ps.setString(3, cliente.getEmailCliente());
            ps.setString(4, cliente.getTelefoneCliente());
            ps.setDate(5, cliente.getDataNascimentoCliente());
            ps.setString(6, cliente.getSexoCliente());
            ps.setString(7, "c");
            ps.setString(8, cliente.getSenhaCliente());
            ps.setString(9, cliente.getCpfCliente());
            ps.setString(10, cliente.getEnderecoCliente());
            ps.setString(11, cliente.getCepCliente());
            ps.setString(12, cliente.getCidadeCliente());
            ps.setString(13, cliente.getEstadoCliente());
            ps.setInt(14, cliente.getIdCliente());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar dados do cliente: " + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        Cliente cliente = (Cliente) ob;

        if (cliente == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM Usuario WHERE idUsuario = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao excluir dados do cliente: " + e);
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
            ps = conn.prepareStatement("SELECT * FROM Usuario WHERE tipoUsuario = 'c'");
            rs = ps.executeQuery();
            List<Cliente> lista = new ArrayList<Cliente>();

            while (rs.next()) {
                Integer idCliente = rs.getInt(1);
                String primeiroNomeCliente = rs.getString(2);
                String segundoNomeCliente = rs.getString(3);
                String email = rs.getString(4);
                String telefone = rs.getString(5);
                Date dataNascimento = rs.getDate(6);
                String sexo = rs.getString(7);
                String tipo = rs.getString(8);
                String senha = rs.getString(9);
                String cpf = rs.getString(10);
                String endereco = rs.getString(11);
                String cep = rs.getString(12);
                String cidade = rs.getString(13);
                String estado = rs.getString(14);
                lista.add(new Cliente(idCliente, primeiroNomeCliente, segundoNomeCliente, email, telefone, dataNascimento, sexo, tipo, senha, cpf, endereco, cep, cidade, estado));
            }
            return lista;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }
    }

    @Override
    public List procura(Object ob) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Cliente cli = (Cliente) ob;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM Usuario WHERE idUsuario = ?");
            ps.setInt(1, cli.getIdCliente());
            rs = ps.executeQuery();
            List<Cliente> lista = new ArrayList<Cliente>();

            while (rs.next()) {
                Integer idCliente = rs.getInt(1);
                String primeiroNomeCliente = rs.getString(2);
                String segundoNomeCliente = rs.getString(3);
                String email = rs.getString(4);
                String telefone = rs.getString(5);
                Date dataNascimento = rs.getDate(6);
                String sexo = rs.getString(7);
                String tipo = rs.getString(8);
                String senha = rs.getString(9);
                String cpf = rs.getString(10);
                String endereco = rs.getString(11);
                String cep = rs.getString(12);
                String cidade = rs.getString(13);
                String estado = rs.getString(14);
                lista.add(new Cliente(idCliente, primeiroNomeCliente, segundoNomeCliente, email, telefone, dataNascimento, sexo, tipo, senha, cpf, endereco, cep, cidade, estado));
            }
            return lista;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.close(conn, ps, rs);
        }
    }

    @Override
    public void salvar(Object ob) throws Exception {
        Cliente cli = (Cliente) ob;
        PreparedStatement ps = null;
        Connection conn = ConnectionDAO.getConnection();

        if (cli == null) {
            throw new Exception("O valor passado não pode ser nulo. Por favor informe valores.");
        }

        try {
            String query = "INSERT INTO Usuario (primeiroNomeUsuario, segundoNomeUsuario, emailUsuario, telefoneUsuario, "
                    + "dataNascimentoUsuario, sexoUsuario, tipoUsuario,  senhaUsuario, "
                    + "cpfUsuario, enderecoUsuario, cepUsuario, cidadeUsuario, estadoUsuario) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, cli.getPrimeiroNomeCliente());
            ps.setString(2, cli.getSegundoNomeCliente());
            ps.setString(3, cli.getEmailCliente());
            ps.setString(4, cli.getTelefoneCliente());
            ps.setDate(5, cli.getDataNascimentoCliente());
            ps.setString(6, cli.getSexoCliente());
            ps.setString(7, cli.getTipoCliente());
            ps.setString(8, cli.getSenhaCliente());
            ps.setString(9, cli.getCpfCliente());
            ps.setString(10, cli.getEnderecoCliente());
            ps.setString(11, cli.getCepCliente());
            ps.setString(12, cli.getCidadeCliente());
            ps.setString(13, cli.getEstadoCliente());
            ps.executeUpdate();
            
            System.out.println(ps);

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir Cliente: " + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}
