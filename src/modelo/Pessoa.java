package modelo;

public class Pessoa {

	private Long cpf;
	private String nome;
	private String sobrenome;
	private String senha;


	public String getSenha() {
		return senha;
	}

	public void setSenha(String string) {
		this.senha = string;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

}
