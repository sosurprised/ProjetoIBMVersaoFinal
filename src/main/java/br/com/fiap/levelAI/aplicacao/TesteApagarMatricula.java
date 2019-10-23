package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.beans.Matricula;
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
			System.out.println(dao.apagarMatricula(9));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dao.fechar();	//executa de qualquer modo ent�o se caso nao abrir a conexao, precisamos colocar o try catch			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
