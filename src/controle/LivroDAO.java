package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ILivroDAO;
import modelo.Livro;

public class LivroDAO {
	
	private static ArrayList<Livro> tabelaLivros;
	public LivroDAO(){
		
	}
	
		public ArrayList<Livro> listar(){
			Conexao c = Conexao.getInstancia();
			Connection con = c.conectar();
			
			String query = "SELECT * FROM livro";
			ArrayList<Livro> livros = new ArrayList<>();
			
			try {
				PreparedStatement ps = con.prepareStatement(query);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Livro l = new Livro();
					
					l.setIsbn(rs.getLong("isbn"));;
					l.setTitulo(rs.getString("titulo"));
					l.setEditora(rs.getString("editora"));
					l.setNrEdicao(rs.getInt("nrEdicao"));
					l.setAnoLancamento(rs.getInt("anoLancamento"));
					l.setAutor(rs.getString("autor"));
					
					livros.add(l);
				}
				}catch (SQLException e ) {
					e.printStackTrace();
				}finally {
					c.fecharConexao();
				}
				return livros;
			}
			
		

	public boolean inserir (Livro l) {
		
		Conexao c = Conexao.getInstancia();
		
		Connection con = c.conectar();
		
		String query = "INSERT INTO livro (isbn, titulo, "
				+ "editora, nrEdicao, anoLancamento, autor) VALUES "
				+ "('?', '?', '?', '?', '?', '?');";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Long.toString(l.getIsbn()));
			ps.setString(2, l.getTitulo());
			ps.setString(3, l.getEditora());
			ps.setString(4, Integer.toString(l.getNrEdicao()));
			ps.setString(5, Integer.toString(l.getAnoLancamento()));
			ps.setString(6, l.getAutor());
			
			//conslida a execução do comando no banco
			ps.executeUpdate();
			
			//fecha conexao
			c.fecharConexao();
		}catch (SQLException l1){
			
			l1.printStackTrace();
			return false;
		}
		return true;	
	}
	
	public boolean atualizar (Livro l) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = "UPDATE livro SET titulo = ?, editora = ?, nrEdicao = ?, "
				+ "anoLancamento = ?, autor = ?  WHERE isbn = ? ";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, l.getTitulo());
			preparedStatement.setString(2, l.getEditora());
			preparedStatement.setInt(3, l.getNrEdicao());
			preparedStatement.setInt(4, l.getAnoLancamento());
			preparedStatement.setString(5, l.getAutor());
	        preparedStatement.setLong(6, l.getIsbn());  // Adiciona o ISBN para a cláusula WHERE

			
			int rowsUpdate = preparedStatement.executeUpdate();
			
			
			if(rowsUpdate > 0) {
				//dadods atualizados
				return true;
			}else {
				//nenhum dado atualizado (isbn pode n existir)
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			c.fecharConexao();
		}
	}
	
	public boolean excluir (Livro l) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = "DELETE FROM livro WHERE  isbn = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, l.getIsbn());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected >0 ) {
				c.fecharConexao();
				return true; //se exclusao bem sucessida
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		c.fecharConexao();	
		}
		return false; //se falha na exclusao
	}
	
	public Livro buscarLivroPorIsbn(Long isbn) {
		for (Livro livros : tabelaLivros) {
			if (livros.getIsbn() == isbn) {
				return livros;
			}
		}
		return null;
	}
	
}
