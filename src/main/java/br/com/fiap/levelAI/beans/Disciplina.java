package br.com.fiap.levelAI.beans;

import java.util.Date;

public class Disciplina {
	private int codigo;
	private String nome;
	private String descricao;
	private Date inicio;
	private Date termino;
	private boolean status;
	
	public Disciplina() {
		
	}

	public Disciplina(int codigo, String nome, String descricao, Date inicio, Date termino, boolean status) {
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

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
