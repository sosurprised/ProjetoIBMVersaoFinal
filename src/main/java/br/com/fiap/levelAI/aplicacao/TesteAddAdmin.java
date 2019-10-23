package br.com.fiap.levelAI.aplicacao;

import br.com.fiap.levelAI.DAO.AdminDAO;
import br.com.fiap.levelAI.beans.Admin;
public class TesteAddAdmin {

	public static void main(String[] args) {
		try {
			AdminDAO dao = new AdminDAO();
			Admin ad = new Admin();
			ad.setCodigo(1);
			ad.setNome("Pessoa12");
			ad.setEmail("123674568@gmail.com");
			ad.setSenha("123425");
			if (dao.addAdmin(ad) == 0) {
				System.out.println("Não cadastrou");
			}else {
				System.out.println("Cadastrado com sucesso");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}