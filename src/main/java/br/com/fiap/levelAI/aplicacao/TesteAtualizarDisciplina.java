package br.com.fiap.levelAI.aplicacao;

import java.util.Date;

import br.com.fiap.levelAI.DAO.DisciplinaDAO;
import br.com.fiap.levelAI.beans.Disciplina;

public class TesteAtualizarDisciplina {
	public static void main(String[] args) throws Exception {
		
		Disciplina disciplina = new Disciplina(56, "Algoritmos", "Era uma vez...", new Date(24/02/1999), new Date(12/07/2008), true);
		DisciplinaDAO dao = new DisciplinaDAO();
		dao.updatedisciplina(disciplina);
		
	}

}
