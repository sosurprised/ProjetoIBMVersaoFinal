package br.com.fiap.levelAI.beans;

import java.util.Date;

public class Matricula {

    private int codigo;
    private Disciplina disciplina;
    private Aluno aluno;
    private Date dataMatricula;
    
    public Matricula() {
    	
    }
    public Matricula(int codigo, Disciplina disciplina, Aluno aluno, Date dataMatricula) {
		this.codigo = codigo;
		this.disciplina= disciplina;
		this.aluno = aluno;
		this.dataMatricula = dataMatricula;
	}
    public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Date getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}




}

