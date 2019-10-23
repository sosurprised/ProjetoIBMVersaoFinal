package br.com.fiap.levelAI.BO;

import br.com.fiap.levelAI.DAO.AdminDAO;
import br.com.fiap.levelAI.beans.Admin;
import br.com.fiap.levelAI.excecao.InvalidValue;

public class AdminBO {
	public void novoAdmin(Admin objAdmin) throws Exception{
	    AdminDAO dao= new AdminDAO();
	    try {	    	
	    	objAdmin.setNome(objAdmin.getNome().toUpperCase());
	        if (objAdmin.getNome().length() <= 0 || objAdmin.getNome().length() > 60) {
	            throw new InvalidValue("Nome inv�lido");
	        }
	    	objAdmin.setEmail(objAdmin.getEmail().toUpperCase());
	        if (objAdmin.getEmail().length() < 0 || objAdmin.getEmail().length() > 60) {
	            throw new InvalidValue("Email inv�lido");
	        }

	        objAdmin.setSenha(objAdmin.getSenha());
	        if (objAdmin.getSenha().length() <= 0 || objAdmin.getSenha().length() > 15) {
	            throw new InvalidValue("Senha inv�lida");
	        }
	        
            Admin adminCodigo = dao.getAdmin(objAdmin.getCodigo());
            if (adminCodigo.getCodigo() > 0) {
                throw new InvalidValue("C�digo j� existe");
            }
            if (dao.addAdmin(objAdmin) == 0) {
                throw new InvalidValue("Admin n�o cadastrado");
            } else {
                System.out.println("Admin cadastrado");
            }	        
        } catch (InvalidValue i) {
            System.out.println(i.getMessage());
        } finally {
            dao.fechar();
	    }
	}
}

	    
