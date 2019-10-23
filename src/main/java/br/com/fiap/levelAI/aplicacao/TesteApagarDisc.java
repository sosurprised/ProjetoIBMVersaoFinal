package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.beans.Disciplina;
import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.DAO.DisciplinaDAO;

public class TesteApagarDisc {

	public static void main(String[] args) {
		DisciplinaDAO dao = null;
		try {
			dao = new DisciplinaDAO();
			Disciplina a = dao.getDisciplina(33);
			System.out.println("Codigo.................:" + a.getCodigo());
			System.out.println("Nome...................:" + a.getNome());
			System.out.println("Descrição..............:" + a.getDescricao());
			System.out.println("Inicio.................:" + a.getInicio());
			System.out.println("Termino................:" + a.getTermino());
			System.out.println("Status.................:" + a.getStatus());
			System.out.println(dao.deleteDisciplina(33));
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
