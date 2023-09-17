package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import modelo.IPessoaDAO;
import modelo.Pessoa;

public class PessoaDAO {

	private static ArrayList<Pessoa> tabelaUsuarios;
	public PessoaDAO() {
		
	}
	
	public ArrayList<Pessoa> listar(){
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
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.fecharConexao();
		}
		return pessoas;
	}
	
	
	//Inserindo pessoa no código:
	public  boolean inserir(Pessoa p){
		
		//Instanciando a classe
		Conexao c = Conexao.getInstancia();
		//Abrindo a conexão com o bd
		Connection con = c.conectar();
		
		String query = "INSERT INTO pessoa (cpf, nome, sobrenome, senha) VALUES (?,?,?,?);";
		
		try {
			//Criando um objeto
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, p.getCpf());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getSobrenome());
			ps.setString(4, p.getSenha());
			
			//Realizando os comandos no banco
			ps.executeUpdate();
			c.fecharConexao();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}		
		return true; //True caso inserção
	}

//	/// Instanciando PessoaDAO
//	public static PessoaDAO getInstancia() {
//
//		if (instancia == null) {
//			instancia = new PessoaDAO();
//			tabelaUsuarios = new ArrayList<>();
//			criarUsuarioEstatico();
//		}
//		return instancia;
//	}

	public static void criarUsuarioEstatico() {

		Pessoa usuarioEstatico = new Pessoa();

		String numeroString = "1234567890";
		long numeroLong = Long.parseLong(numeroString);

		// Defina os atributos do usuário estático
		usuarioEstatico.setCpf(numeroLong);

		usuarioEstatico.setNome("Patricia");
		usuarioEstatico.setSobrenome("Cordeiro");
		usuarioEstatico.setSenha("welcome");

		// Adicione o usuário estático à tabela de usuários
		tabelaUsuarios.add(usuarioEstatico);

	}

	public Pessoa efetuarLogin(long cpf, String senha) {
		Pessoa p = null;

		for (Pessoa pessoa : tabelaUsuarios) {
			System.out.println("senha");
			System.out.println(pessoa.getSenha());
			if (pessoa.getSenha().equals(senha) && pessoa.getCpf() == cpf) {
				p = pessoa;
				break;
			}
		}

		return p;
	}

	/// Cadastro de novo usuario no sistema
//	public boolean cadastrarPessoa(Pessoa p) {
//		if (p != null) {
//			tabelaUsuarios.add(p);
//			return true;
//		}
//		return false;
//	}
	
	

	public boolean atualizar(Pessoa p) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = "UPDATE pessoa SET nome = ?, "
				+ "sobrenome = ?, senha = ? WHERE cpf = ?";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, p.getNome());
			preparedStatement.setString(2, p.getSobrenome());
			preparedStatement.setString(3, p.getSenha());
			preparedStatement.setLong(4, p.getCpf());
			
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
		

	/// Deletar pessoa com base no cpf digitado
	public boolean excluir(Pessoa p) {
		
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = "DELETE FROM pessoa WHERE cpf = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, p.getCpf());
			
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

	/// Pendente descobrir como usar listagem com interface grafica
	public ArrayList<Pessoa> listarPessoas() {
		return tabelaUsuarios;

	}

	public Pessoa buscarPessoaCpf(long cpf) {
		for (Pessoa pessoa : tabelaUsuarios) {
			if (pessoa.getCpf() == cpf) {
				System.out.println(pessoa.getCpf());
				return pessoa;
			}
		}
		return null;
	}

}
