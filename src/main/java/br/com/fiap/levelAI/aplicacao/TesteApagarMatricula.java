package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.beans.Matricula;
import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.DAO.MatriculaDAO;

public class TesteApagarMatricula {

	public static void main(String[] args) {
		MatriculaDAO dao = null;
		try {
			dao = new MatriculaDAO();
			Matricula a = dao.getMatricula(9);
			System.out.println("Codigo.................:" + a.getCodigo());
			System.out.println("Disciplina.............:" + a.getDisciplina());
			System.out.println("Aluno..................:" + a.getAluno());
			System.out.println("Data de Matricula......:" + a.getDataMatricula());
			System.out.println(dao.deleteMatricula(9));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				Conexao.fechar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
