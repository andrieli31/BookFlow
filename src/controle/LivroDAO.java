package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ILivroDAO;
import modelo.Livro;

public class LivroDAO {

	public boolean inserir (Livro l) {
		
		Conexao c = Conexao.getInstancia();
		
		Connection con = c.conectar();
		
		String query = "INSERT INTO livro (isbn, titulo, editora, nrEdicao, anoLancamento, autor) VALUES ('?', '?', '?', '?', '?', '?');";
		
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
}
