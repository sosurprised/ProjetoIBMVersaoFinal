package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.DAO.AdminDAO;
import br.com.fiap.levelAI.beans.Admin;
import br.com.fiap.levelAI.conexao.Conexao;

public class TesteConsultaAdmin {

	public static void main(String[] args) throws Exception {
		AdminDAO dao = null;
		try {
			dao = new AdminDAO();
			Admin ad = dao.getAdmin(6);
			System.out.println("Codigo admin.......: " + ad.getCodigo());
			System.out.println("Nome admin:" + ad.getNome());
			System.out.println("Email admin.......... " + ad.getEmail());
			System.out.println("Senha admin.......... " + ad.getSenha());

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				Conexao.fechar();	//executa de qualquer modo ent�o se caso nao abrir a conexao, precisamos colocar o try catch			
			} catch (Exception e) {
				e.printStackTrace();
			}		
						
	}

}

}
