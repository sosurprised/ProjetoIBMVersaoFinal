package br.com.fiap.levelAI.aplicacao;

import java.util.Date;

import br.com.fiap.levelAI.DAO.CapituloDAO;
import br.com.fiap.levelAI.beans.Capitulo;
import br.com.fiap.levelAI.beans.Disciplina;


public class TesteAtualizarCapitulo {

	public static void main(String[] args) throws Exception {
		
	Capitulo capitulo = new Capitulo(1234, new Disciplina(56, "Algoritmos", "Era uma vez...", new Date(24/02/1999), new Date(12/07/2008), true), "Introdução", "blablabla....");
		CapituloDAO dao = new CapituloDAO();
		dao.updatecapitulo(capitulo);
		
	}
}
