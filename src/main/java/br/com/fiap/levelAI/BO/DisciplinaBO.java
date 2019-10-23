package br.com.fiap.levelAI.BO;

import br.com.fiap.levelAI.DAO.DisciplinaDAO;
import br.com.fiap.levelAI.beans.Disciplina;
import br.com.fiap.levelAI.excecao.InvalidValue;

/**
 * Esta classe tem como finalidade validar as Disciplinas do LevelAi
 * @author patricia
 *@author Nadia
 */
public class DisciplinaBO {

    /*
    VERIFICAR STATUS, NAO SEI COMO TRATAR
     */

	/**
	 * Este metodo tem como finalidade validar uma nova disciplina
	 * 
	 * @author patricia
	 * @author Nadia
	 * @param objDisciplina - recebe um objeto do tipo disciplina
	 * @throws Exception    - é lançado quando acontecer uma exceção
	 * @throws InvalidValue - é lançado quando o valor dos atributos verificados
	 *                      pelo método tiver um valor inválido
	 */
    public void novaDisciplina(Disciplina objDisciplina) throws Exception {
        DisciplinaDAO dao = null;
        try {
            objDisciplina.setNome(objDisciplina.getNome().toUpperCase());
            if (objDisciplina.getNome().length() <= 0|| objDisciplina.getNome().length() > 20) {
                throw new InvalidValue("Nome inv�lido");
            }
            objDisciplina.setDescricao(objDisciplina.getDescricao().toUpperCase());
            if (objDisciplina.getDescricao().length() <= 0 || objDisciplina.getDescricao().length() >= 100) {
                throw new InvalidValue("Descri��o inv�lida");
            }

            /* TRATAR DT_INICIO AQUI*/

            /*TRATAR STATUS AQUI*/


            dao = new DisciplinaDAO();
            Disciplina disciplinaCodigo = dao.getDisciplina(objDisciplina.getCodigo());
            if (disciplinaCodigo.getCodigo() > 0) {
                throw new InvalidValue("C�digo j� existe");
            }

            if (dao.addDisciplina(objDisciplina) == 0) {
                throw new InvalidValue("Disciplina n�o cadastrada");
            } else {
                System.out.println("Disciplina cadastrada");
            }
        } catch (InvalidValue i) {
            System.out.println(i.getMessage());
        } finally {
            dao.fechar();
        }

    }
}
