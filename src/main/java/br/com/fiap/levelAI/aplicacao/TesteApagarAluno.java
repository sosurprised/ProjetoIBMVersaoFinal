package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.beans.Aluno;
import br.com.fiap.levelAI.DAO.AlunoDAO;

public class TesteApagarAluno {

	public static void main(String[] args) {
		AlunoDAO dao = null;
		try {
			dao = new AlunoDAO();
			Aluno a = dao.getAluno(55);
			System.out.println("Codigo.................:" + a.getCodigo());
			System.out.println("Nome...................:" + a.getNome());
			System.out.println("Endereço...............:" + a.getEndereco());
			System.out.println("Telefone...............:" + a.getTelefone());
			System.out.println("Data de nascimento.....:" + a.getDataNascimento());
			System.out.println("Email..................:" + a.getEmail());
			System.out.println("Senha..................:" + a.getSenha());
			System.out.println(dao.apagarAluno(55));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dao.fechar();		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
