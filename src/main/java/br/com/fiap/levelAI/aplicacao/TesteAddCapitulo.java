package br.com.fiap.levelAI.aplicacao;


import br.com.fiap.levelAI.DAO.CapituloDAO;
import br.com.fiap.levelAI.DAO.DisciplinaDAO;
import br.com.fiap.levelAI.beans.Capitulo;



public class TesteAddCapitulo {

	public static void main(String[] args) {
		try {
			CapituloDAO dao = new CapituloDAO();
			Capitulo cap = new Capitulo();
			DisciplinaDAO dDAO = new DisciplinaDAO();
			cap.setCodigo(12);
			cap.setDisciplina(dDAO.getDisciplina(22));
			cap.setTitulo("ABCDuiope");
			cap.setConteudo("1234650000");
			if (dao.addCapitulo(cap)==0) {
				System.out.println("N�o cadastrou");
			}else {
				System.out.println("Cadastrado com sucesso");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
