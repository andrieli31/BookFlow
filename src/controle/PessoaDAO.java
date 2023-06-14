package controle;

import java.util.ArrayList;

import modelo.IPessoaDAO;
import modelo.Pessoa;

public class PessoaDAO implements IPessoaDAO {

	private static ArrayList<Pessoa> tabelaUsuarios;
	private static PessoaDAO instancia;

	/// Construtor
	private PessoaDAO() {    
	    tabelaUsuarios = new ArrayList<>(); // Inicializa a lista de usuários
		criarUsuarioEstatico();

	}

	
	
	public boolean criarUsuarioEstatico() {
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

	    return true;
	}

	
	
	
	
	public Pessoa efetuarLogin(String login, String senha) {
		Pessoa p = null;

		for (Pessoa pessoa : tabelaUsuarios) {
			if (pessoa.getSenha().equals(senha) && pessoa.getCpf().equals(login)) {
				p = pessoa;			
			
			}
		}

		return p;
	}

	/// Instanciando PessoaDAO
	public static PessoaDAO getInstancia() {
		if (instancia == null) {
			instancia = new PessoaDAO();
			tabelaUsuarios = new ArrayList<>();
		}
		return instancia;
	}

	/// Cadastro de novo usuario no sistema
	public boolean cadastrarPessoa(Pessoa p) {
		if (p != null) {
			tabelaUsuarios.add(p);
			return true;
		}
		return false;
	}

	/// alterando apenas o cpf do usuario, verificar para alteração dos outros dados
	/// pendentes
	public boolean alterarPessoa(Pessoa p, Long cpf, String nome, String sobrenome, String email, String senha) {
		for (Pessoa pessoa : tabelaUsuarios) {
			if (pessoa.getCpf().equals(cpf)) {
				pessoa.setCpf(cpf);
				pessoa.setNome(nome);
				pessoa.setSobrenome(sobrenome);
				pessoa.setSenha(senha);
				return true;
			}
		}
		return false;
	}

	/// Deletar pessoa com base no cpf digitado
	public boolean deletarPessoa(Pessoa p, Long cpf) {
		for (Pessoa pessoa : tabelaUsuarios) {
			if (pessoa.getCpf().equals(cpf)) {
				tabelaUsuarios.remove(pessoa);
				return true;
			}
		}
		return false;
	}

	/// Pendente descobrir como usar listagem com interface grafica
	public ArrayList<Pessoa> listarPessoas() {
		return tabelaUsuarios;

	}

}
