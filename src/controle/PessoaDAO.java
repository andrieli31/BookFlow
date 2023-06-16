package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.IPessoaDAO;
import modelo.Pessoa;

public class PessoaDAO implements IPessoaDAO {

	private static ArrayList<Pessoa> tabelaUsuarios;
	private static PessoaDAO instancia;

	/// Construtor
	public PessoaDAO() {    
	    tabelaUsuarios = new ArrayList<>(); // Inicializa a lista de usuários
		criarUsuarioEstatico();

	}

	/// Instanciando PessoaDAO
	public static PessoaDAO getInstancia() {
		if (instancia == null) {
			instancia = new PessoaDAO();
			tabelaUsuarios = new ArrayList<>();
		}
		return instancia;
	}

	
	public boolean criarUsuarioEstatico() {
	  
		  if (tabelaUsuarios == null) {
		        tabelaUsuarios = new ArrayList<>(); // Inicializa a lista de usuários
		    }
		    
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

	    System.out.println(tabelaUsuarios);
	    
	    return true;
	}

	
	public Pessoa efetuarLogin(long cpf, String senha) {
	    Pessoa p = null;

	    for (Pessoa pessoa : tabelaUsuarios) {
	         
	        if (pessoa.getSenha().equals(senha) && pessoa.getCpf() == cpf) {
	            p = pessoa;
	            break;
	        }
	    }

	    return p;
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
	public boolean alterarPessoa(Pessoa p) {
		for (Pessoa pessoa : tabelaUsuarios) {
			if (pessoa.getCpf()== p.getCpf()) {
				pessoa.setCpf(p.getCpf());
				pessoa.setNome(p.getNome());
				pessoa.setSobrenome(p.getSobrenome());
				pessoa.setSenha(p.getSenha());
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
	
	public Pessoa buscarPessoaCpf (long cpf) {
		for (Pessoa pessoa : tabelaUsuarios) {
			if(pessoa.getCpf() == cpf) {
				System.out.println(pessoa.getCpf());
				return pessoa;
			}
		}
		return null;
	}



	

}
