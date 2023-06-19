package modelo;

import java.util.ArrayList;

public interface IPessoaDAO {

	public boolean cadastrarPessoa(Pessoa p);

	public boolean alterarPessoa(Pessoa p);

	public boolean deletarPessoa(Pessoa p, Long cpf);

	public ArrayList<Pessoa> listarPessoas();

	public Pessoa buscarPessoaCpf(long cpf);

	public Pessoa efetuarLogin(long cpf, String senha);
}
