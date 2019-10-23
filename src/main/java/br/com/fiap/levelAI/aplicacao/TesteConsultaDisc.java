package br.com.fiap.levelAI.aplicacao;
import br.com.fiap.levelAI.beans.Disciplina;
import br.com.fiap.levelAI.DAO.DisciplinaDAO;

public class TesteConsultaDisc {

	public static void main(String[] args) throws Exception {
		DisciplinaDAO dao = null;
		try {
			dao = new DisciplinaDAO();
			Disciplina d = dao.getDisciplina(30);
			System.out.println("Codigo disciplina.......: " + d.getCodigo());
			System.out.println("Nome:" + d.getNome());
			System.out.println("Desc.......... " + d.getDescricao());
			System.out.println("Inicio.......... " + d.getInicio());
			System.out.println("Termino.......... " + d.getTermino());

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


