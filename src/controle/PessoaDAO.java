package controle;

import java.util.ArrayList;

import modelo.IPessoaDAO;
import modelo.Pessoa;

public class PessoaDAO implements IPessoaDAO {

	private static ArrayList<Pessoa> tabelaUsuarios;
	private static PessoaDAO instancia;

	/// Construtor
	private PessoaDAO() {

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
				pessoa.setEmail(email);
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
