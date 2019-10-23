package br.com.fiap.levelAI.aplicacao;
import br.com.fiap.levelAI.beans.Capitulo;
import br.com.fiap.levelAI.DAO.CapituloDAO;

public class TesteApagarCapitulo {

	public static void main(String[] args) {
		CapituloDAO dao = null;
		try {
			dao = new CapituloDAO();
			Capitulo a = dao.getCapitulo(12);
			System.out.println("Codigo.................:" + a.getCodigo());
			System.out.println("Disciplina.............:" + a.getDisciplinaCapitulo());
			System.out.println("Titulo.................:" + a.getTitulo());
			System.out.println("Conteudo...............:" + a.getConteudo());
			System.out.println(dao.apagarCapitulo(12));
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
