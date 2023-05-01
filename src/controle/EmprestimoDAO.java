package controle;

import java.util.ArrayList;

import modelo.Emprestimo;
import modelo.IEmprestimoDAO;
import modelo.Livro;
import modelo.Pessoa;

public class EmprestimoDAO implements IEmprestimoDAO {

	private static ArrayList<Emprestimo> tabelaEmprestimos;
	private static EmprestimoDAO instancia;

	private EmprestimoDAO() {

	}

	public static EmprestimoDAO getInstancia() {
		if (instancia == null) {
			instancia = new EmprestimoDAO();
			tabelaEmprestimos = new ArrayList<>();
		}
		return instancia;
	}

	/// cadastro de novo emprestimo no sistema
	public boolean cadastrarEmprestimo(Emprestimo e) {
		if (e != null) {
			tabelaEmprestimos.add(e);
			return true;
		}
		return false;
	}

/// alteracao de um emprestimo existente no sistema
	public boolean alterarEmprestimo(Emprestimo e, Long id, ArrayList<Livro> livros, Pessoa p) {
		for (Emprestimo emprestimo : tabelaEmprestimos) {
			if (emprestimo.getId() == id) {
				emprestimo.setId(id);
				emprestimo.setLivros(livros);
				emprestimo.setPessoa(p);
				return true;
			}

		}

		return false;
	}

// Deletar um emprestimo existente no sistema com base no seu id
	public boolean deletarEmprestimo(Emprestimo e, Long id) {
		for (Emprestimo emprestimo : tabelaEmprestimos) {
			if (emprestimo.getId() == id) {
				tabelaEmprestimos.remove(emprestimo);
				return true;
			}
		}

		return false;
	}

	/// Listar emprestimos existentes no sistema
	public ArrayList<Emprestimo> listarEmprestimos() {
		return this.tabelaEmprestimos;
	}

}
