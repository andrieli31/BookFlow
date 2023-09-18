package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Categoria;
import modelo.ICategoriaDAO;
import modelo.Pessoa;

public class CategoriaDAO  {


	public CategoriaDAO() {
	}

	// inserir no banco
	public boolean inserir(Categoria e) {

		// instancia a classe conexao
		Conexao c = Conexao.getInstancia();
		// abre a conexao com o banco
		Connection con = c.conectar();

		String query = "INSERT INTO categoria (idCategoria, ididioma, quantPaginas, genero) VALUES (?, ?, ?, ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, e.getIdCategoria());
			ps.setString(2, e.getIdioma());
			ps.setLong(3, e.getQuantPaginas());
			ps.setString(4, e.getGenero());

			ps.executeUpdate();

			c.fecharConexao();
		} catch (SQLException e1) {
			e1.printStackTrace();
			// retorna false se der errado
			return false;
		}
		// retorna true se der certo
		return true;
	}

	// alterar
	public boolean atualizar(Categoria f) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE categoria SET idioma = ?, quantPaginas = ?, genero = ? WHERE idCategoria = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, f.getIdioma());
			ps.setInt(2, f.getQuantPaginas());
			ps.setString(3, f.getGenero());
			ps.setInt(4, f.getIdCategoria());

			ps.executeUpdate();

			c.fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			c.fecharConexao();
		}

		return true;
	}

	

	// excluir
	public boolean excluir(Categoria e) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM categoria WHERE idCategoria = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, e.getIdCategoria());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				c.fecharConexao();
				return true;
			}
		} catch (SQLException e1) {
			 e1.printStackTrace();
	    } finally {
	        c.fecharConexao();
	    }

		return false;

	}

	
	// listar
	public ArrayList<Categoria> listar() {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		ArrayList<Categoria> categoria = new ArrayList<>();

		String query = "SELECT * FROM categoria";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int IdCategoria = rs.getInt("idCategoria");
				String Idioma = rs.getString("idioma");
				int QuantPaginas = rs.getInt("quantPaginas");
				String Genero = rs.getString("genero");

				Categoria cat = new Categoria();
				cat.setIdCategoria(IdCategoria);
				cat.setIdioma(Idioma);
				cat.setQuantPaginas(QuantPaginas);
				cat.setGenero(Genero);

				categoria.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return categoria;
	}

    public Categoria buscarCategoriaPorID(int id) {
        Conexao c = Conexao.getInstancia();

        Connection con = c.conectar();
        Categoria cat = new Categoria();

        try {


            // Consulta SQL para buscar a pessoa com base no ID
            String query = "SELECT * FROM categoria WHERE idCategoria = ?";

            PreparedStatement ps = con.prepareStatement(query);


            ps.setInt(1, id);

            var rs = ps.executeQuery();

            if (rs.next()) {
                cat.setIdioma("idioma");
                cat.setGenero("genero");
                cat.setQuantPaginas(rs.getInt("quantPaginas"));
       
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            c.fecharConexao();
        }

        return cat; // Retorna a pessoa encontrada ou null se não encontrada
    }

}
