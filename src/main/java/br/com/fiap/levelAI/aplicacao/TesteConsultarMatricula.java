package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.beans.Matricula;
import br.com.fiap.levelAI.DAO.MatriculaDAO;

public class TesteConsultarMatricula {

	public static void main(String[] args) throws Exception {
		MatriculaDAO dao = null;
		try {
			dao = new MatriculaDAO();
			Matricula a = dao.getMatricula(55);
			System.out.println("Codigo............:" + a.getCodigo());
			System.out.println("Disciplina........:" + a.getDisciplina());
			System.out.println("Aluno.............:" + a.getAluno());
			System.out.println("Data de Matricula.:" + a.getDataMatricula());

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dao.fechar();			
						
	}

	}

}
