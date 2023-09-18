package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {

    public ArrayList<Pessoa> listar() {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "SELECT * FROM pessoa";
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setCpf(rs.getLong("cpf"));
                p.setNome(rs.getString("nome"));
                p.setSobrenome(rs.getString("sobrenome"));
                p.setSenha(rs.getString("senha"));

                pessoas.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.fecharConexao();
        }
        return pessoas;
    }

    
    
    // Inserindo pessoa no código:
    public boolean inserir(Pessoa p) {
        // Instanciando a classe
        Conexao c = Conexao.getInstancia();
        // Abrindo a conexão com o bd
        Connection con = c.conectar();

        String query = "INSERT INTO pessoa (cpf, nome, sobrenome, senha) VALUES (?,?,?,?);";

        try {
            // Criando um objeto
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, p.getCpf());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getSobrenome());
            ps.setString(4, p.getSenha());

            // Realizando os comandos no banco
            ps.executeUpdate();
            c.fecharConexao();

        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
        return true; // True caso inserção
    }

    public boolean fazerLogin(long cpf, String senha) {
        String selectQuery = "SELECT * FROM login WHERE cpf = ? AND senha= ?";
        
        
        try (Connection connection = Conexao.getInstancia().conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setLong(1, cpf);
            preparedStatement.setString(2, senha);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizar(Pessoa p) {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "UPDATE pessoa SET nome = ?, sobrenome = ?, senha = ? WHERE cpf = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, p.getNome());
            preparedStatement.setString(2, p.getSobrenome());
            preparedStatement.setString(3, p.getSenha());
            preparedStatement.setLong(4, p.getCpf()); // CPF não é atualizado

            int rowsUpdate = preparedStatement.executeUpdate();

            if (rowsUpdate > 0) {
                // Dados atualizados
                return true;
            } else {
                // Nenhum dado atualizado (CPF pode não existir)
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            c.fecharConexao();
        }
    }

    
    // MÉTODO OK

    public boolean excluir(Pessoa p) {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "DELETE FROM pessoa WHERE cpf = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, p.getCpf());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                c.fecharConexao();
                return true; // se exclusao bem sucessida
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.fecharConexao();
        }
        return false; // se falha na exclusao
    }

 
    public Pessoa buscarPessoaCpf(String cpf) {
        Conexao c = Conexao.getInstancia();

        Connection con = c.conectar();
        Pessoa p = new Pessoa();

        try {


            // Consulta SQL para buscar a pessoa com base no CPF
            String query = "SELECT * FROM pessoa WHERE cpf = ?"; // Supondo que sua tabela se chama "pessoa"

            PreparedStatement ps = con.prepareStatement(query);


            ps.setString(1, cpf);

            var rs = ps.executeQuery();

            if (rs.next()) {
                p.setNome(rs.getString("nome"));
                p.setSobrenome(rs.getString("sobrenome"));
                p.setCpf(rs.getLong("cpf"));
                p.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            c.fecharConexao();
        }

        return p; // Retorna a pessoa encontrada ou null se não encontrada
    }

}
