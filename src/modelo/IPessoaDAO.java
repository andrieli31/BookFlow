package modelo;

import java.util.ArrayList;

public interface IPessoaDAO {

	public boolean cadastrarPessoa(Pessoa p);

	public boolean alterar(Pessoa p, Long cpf);

	public boolean deletar(Pessoa p, Long cpf);
	
	public ArrayList<Pessoa> listarPessoas();

}
