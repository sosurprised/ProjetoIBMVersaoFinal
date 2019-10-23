package br.com.fiap.levelAI.BO;

import br.com.fiap.levelAI.DAO.CapituloDAO;
import br.com.fiap.levelAI.beans.Capitulo;
import br.com.fiap.levelAI.excecao.InvalidValue;

/**
 * Esta classe tem como finalidade validar os Capitulos do levelAi
 * @author patricia
 * @author Nadia
 */
public class CapituloBO {
	/**
	 * Este metódo valida: Código, titulo e conteudo de um novo Capitulo do LevelAi
	 * 
	 * @author patricia
	 * @author Nadia
	 * @param objCapitulo - Recebe um objeto do tipo Capitulo
	 * @throws Exception    - é lançado quando acontecer alguma exceção
	 * @throws InvalidValue - é lançado quando o valor dos atributos verificados
	 *                      pelo método tiver um valor inválido
	 */
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
		            dao.fechar();
		        }
		
		    }
		}



