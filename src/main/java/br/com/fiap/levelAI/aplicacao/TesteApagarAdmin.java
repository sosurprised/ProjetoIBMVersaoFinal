package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.beans.Admin;
import br.com.fiap.levelAI.DAO.AdminDAO;


public class TesteApagarAdmin {

	public static void main(String[] args) {
		AdminDAO dao = null;
		try {
			dao = new AdminDAO();
			Admin a = dao.getAdmin(1);
			System.out.println("Codigo.................:" + a.getCodigo());
			System.out.println("Nome...................:" + a.getNome());
			System.out.println("Email..................:" + a.getEmail());
			System.out.println("Senha..................:" + a.getSenha());
			System.out.println(dao.apagarAdmin(1));
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
