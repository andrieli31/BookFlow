package modelo;

import java.util.ArrayList;

public interface IEmprestimoDAO {

	public boolean cadastrarEmprestimo(Emprestimo e);

	public boolean alterarEmprestimo(Emprestimo e, Long id, ArrayList<Livro> livros, Pessoa p);

	public boolean deletarEmprestimo(Emprestimo e, Long id);

	public ArrayList<Emprestimo> listarEmprestimos();

}
