package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.beans.Aluno;
import br.com.fiap.levelAI.DAO.AlunoDAO;

public class TesteConsultaAluno {

	public static void main(String[] args) throws Exception {
		AlunoDAO dao = null;
		try {
			dao = new AlunoDAO();
			Aluno a = dao.getAluno(11);
			System.out.println("Codigo.......:" + a.getCodigo());
			System.out.println("Nome:" + a.getNome());
			System.out.println("Endere�o.........." + a.getEndereco());
			System.out.println("Tel.........." + a.getTelefone());
			System.out.println("Data.........." + a.getDataNascimento());
			System.out.println("Email.........." + a.getEmail());

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


