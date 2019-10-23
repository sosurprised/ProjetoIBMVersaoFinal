package br.com.fiap.levelAI.BO;

import br.com.fiap.levelAI.DAO.CapituloDAO;
import br.com.fiap.levelAI.beans.Capitulo;
import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.excecao.InvalidValue;

public class CapituloBO {
		  public void novoCapitulo(Capitulo objCapitulo) throws Exception {
		        CapituloDAO dao = new CapituloDAO();
		        try {
		            objCapitulo.setCodigo(objCapitulo.getCodigo());
		            if (objCapitulo.getCodigo()<=0) {
		                throw new InvalidValue("Capitulo inexistente.");
		            }
		            objCapitulo.setDisciplina(objCapitulo.getDisciplinaCapitulo());
		            if (objCapitulo.getCodigo() <= 0) {
		                throw new InvalidValue("Disciplina inexistente.");
		            }

		            objCapitulo.setTitulo(objCapitulo.getTitulo());
		            if (objCapitulo.getTitulo().length() <= 0) {
		                throw new InvalidValue("Titulo invalido");
		            }

		            objCapitulo.setConteudo(objCapitulo.getConteudo());
		            if (objCapitulo.getConteudo().length() <= 0) {
		                throw new InvalidValue("Conteudo inexixtente");
		            }


		        } catch (InvalidValue i) {
		            System.out.println(i.getMessage());
		        } finally {
					Conexao.fechar();
		        }
		
		    }
		}



