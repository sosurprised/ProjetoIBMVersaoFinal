  
package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.DAO.AdminDAO;
import br.com.fiap.levelAI.beans.Admin;

public class TesteAtualizarAdmin {
	
	public static void main(String[] args) throws Exception {
		
		Admin admin = new Admin(1, "djovana", "dev@gmail", "45678901");
		AdminDAO dao = new AdminDAO();
		dao.updateAdmin(admin);
		
	}

}