package br.com.fiap.levelAI.BO;

import br.com.fiap.levelAI.DAO.MatriculaDAO;
import br.com.fiap.levelAI.beans.Matricula;
import br.com.fiap.levelAI.excecao.InvalidValue;

public class MatriculaBO {
	    /*
	        Verificar menor quantidade dos atributoss
	        criar check para nascimento
	    */
	    public void novoMatricula(Matricula objMatricula ) throws Exception {
	        MatriculaDAO dao = new MatriculaDAO();
	        try {
	            objMatricula.setCodigo(objMatricula.getCodigo());
	            if (objMatricula.getCodigo()!= 6) {
	                throw new InvalidValue("C�digo inv�lido");
	            }
	            objMatricula.setDisciplina(objMatricula.getDisciplina());
	            if (objMatricula.getDisciplina().getCodigo() >100 || objMatricula.getDisciplina().getCodigo() <=0 ) {
	                throw new InvalidValue("Disciplina inv�lida");
	            }

	            objMatricula.setAluno(objMatricula.getAluno());
	            if (objMatricula.getAluno().getCodigo() <=0 || objMatricula.getAluno().getCodigo()>99999) {
	                throw new InvalidValue("C�digo inv�lido");
	            }
	            objMatricula.setDataMatricula(objMatricula.getDataMatricula());
	            if (objMatricula.getDataMatricula().length()< 8) {
	                throw new InvalidValue("Data inv�lida");
	            } 
	        }
	        catch (InvalidValue i) {
	            System.out.println(i.getMessage());
	        } finally {
	            dao.fechar();
	        }
	  }
}


