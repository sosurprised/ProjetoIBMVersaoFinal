package br.com.fiap.levelAI.beans;

public class Admin {
	private int codigo;
	private String nome;
	private String email;
	String senha;
	
	public Admin() {
		
	}

	public Admin(int codigo, String nome, String email, String senha) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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
