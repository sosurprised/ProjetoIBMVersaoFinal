package br.com.fiap.levelAI.aplicacao;

import java.util.Date;

import br.com.fiap.levelAI.DAO.DisciplinaDAO;
import br.com.fiap.levelAI.beans.Disciplina;

public class TesteAddDisciplina {

	public static void main(String[] args) {
			try {
				DisciplinaDAO dao = new DisciplinaDAO();
				Disciplina ad = new Disciplina();
				ad.setCodigo(50);
				ad.setNome("Fisica");
				ad.setDescricao("Introdução");
				ad.setInicio(new Date(15/2/2019));
				ad.setTermino(new Date(19/5/2019));
				ad.setStatus(false);
				if (dao.addDisciplina(ad) == 0) {
					System.out.println("N�o cadastrou");
				}else {
					System.out.println("Cadastrado com sucesso");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
