package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.beans.Capitulo;
import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.DAO.CapituloDAO;

public class TesteConsultarCapitulo {

	public static void main(String[] args) throws Exception {
		CapituloDAO dao = null;
		try {
			dao = new CapituloDAO();
			Capitulo a = dao.getCapitulo(1);
			System.out.println("Codigo.......:" + a.getCodigo());
			System.out.println("Disciplina:" + a.getDisciplinaCapitulo());
			System.out.println("Titulo .........." + a.getTitulo());
			System.out.println("Conteudo.........." + a.getConteudo());

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
