package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.DAO.AlunoDAO;
import br.com.fiap.levelAI.beans.Aluno;

public class TesteAddAluno {

	public static void main(String[] args) {
		try {
			AlunoDAO dao = new AlunoDAO();
			Aluno alu = new Aluno();
			alu.setCodigo(55);
			alu.setNome("Matem�tica");
			alu.setEndereco("24");
			alu.setTelefone("11946079854");
			alu.setDataNascimento("12/3/67");
			alu.setEmail("gg@gg.com.br");
			alu.setSenha("123456");
			if (dao.addAluno(alu) == 0) {
				System.out.println("N�o cadastrou");
			}else {
				System.out.println("Cadastrado com sucesso");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
