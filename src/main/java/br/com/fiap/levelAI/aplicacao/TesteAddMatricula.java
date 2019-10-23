package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.beans.Matricula;
import br.com.fiap.levelAI.DAO.AlunoDAO;
import br.com.fiap.levelAI.DAO.DisciplinaDAO;
import br.com.fiap.levelAI.DAO.MatriculaDAO;


public class TesteAddMatricula {

	public static void main(String[] args) {
		try {
			MatriculaDAO dao = new MatriculaDAO();
			Matricula mat = new Matricula();
			DisciplinaDAO d = new DisciplinaDAO();
			AlunoDAO a = new AlunoDAO();
			mat.setCodigo(9);
			mat.setDisciplina(d.getDisciplina(50));
			mat.setAluno(a.getAluno(11));
			mat.setDataMatricula("11/2/2019");
			if (dao.addMatricula(mat) == 0) {
				System.out.println("N�o cadastrou");
			}else {
				System.out.println("Cadastrado com sucesso");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
