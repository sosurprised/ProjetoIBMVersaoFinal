package br.com.fiap.levelAI.beans;


public class Disciplina {
	private int codigo;
	private String nome;
	private String descricao;
	private String inicio;
	private String termino;
	private String status;
	
	public Disciplina() {
		
	}

	public Disciplina(int codigo, String nome, String descricao, String inicio, String termino, String status) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.inicio = inicio;
		this.termino = termino;
		this.status = status;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
