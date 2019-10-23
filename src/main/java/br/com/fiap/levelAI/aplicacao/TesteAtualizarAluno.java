package br.com.fiap.levelAI.aplicacao;

import java.util.Date;

import br.com.fiap.levelAI.DAO.AlunoDAO;
import br.com.fiap.levelAI.beans.Aluno;

public class TesteAtualizarAluno {
	
	public static void main(String[] args) throws Exception {
		
		Aluno aluno = new Aluno(2346, "Kesia", "rua sao bento", "11965784563", new Date(12/4/1987), "dev@.com.br", "batata123455");
		AlunoDAO dao = new AlunoDAO();
		dao.updateAluno(aluno);
		
	}

}
