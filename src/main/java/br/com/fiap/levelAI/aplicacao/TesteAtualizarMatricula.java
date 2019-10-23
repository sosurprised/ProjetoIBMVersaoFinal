package br.com.fiap.levelAI.aplicacao;

import java.util.Date;

import br.com.fiap.levelAI.DAO.MatriculaDAO;
import br.com.fiap.levelAI.beans.Aluno;
import br.com.fiap.levelAI.beans.Disciplina;
import br.com.fiap.levelAI.beans.Matricula;

public class TesteAtualizarMatricula {

	public static void main(String[] args) throws Exception {

		Matricula matricula = new Matricula(2345,
				new Disciplina(56, "Algoritmos", "Era uma vez...", new Date(24 / 02 / 1999), new Date(12 / 07 / 2008),
						true),
				new Aluno(2346, "Kesia", "rua sao bento", "11965784563", new Date(12 / 4 / 1987), "dev@.com.br",
						"batata123455"),
				new Date());
		MatriculaDAO dao = new MatriculaDAO();
		dao.updateMatricula(matricula);

	}

}
