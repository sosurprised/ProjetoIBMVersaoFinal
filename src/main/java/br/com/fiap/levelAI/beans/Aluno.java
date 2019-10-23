package br.com.fiap.levelAI.beans;


public class Aluno {
	private int codigo;
	private String nome;
	private String endereco;
	private String telefone;
	private String dataNascimento;
	private String email;
	private String senha;

	public Aluno() {
		
	}
	
	public Aluno(int codigo, String nome, String endereco, String telefone, String dataNascimento, String email,
			String senha) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}