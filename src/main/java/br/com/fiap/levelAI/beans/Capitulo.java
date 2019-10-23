package br.com.fiap.levelAI.beans;

public class Capitulo {
	private int codigo;
	private Disciplina disciplina;
	private String titulo;
	private String conteudo;

	public Capitulo() {
		
	}

	public Capitulo(int codigo, Disciplina disciplina, String titulo, String conteudo) {
		super();
		this.codigo = codigo;
		this.disciplina = disciplina;
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public Disciplina getDisciplinaCapitulo() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
}
