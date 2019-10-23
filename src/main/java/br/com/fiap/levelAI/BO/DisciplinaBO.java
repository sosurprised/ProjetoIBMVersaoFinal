package br.com.fiap.levelAI.BO;

import br.com.fiap.levelAI.DAO.DisciplinaDAO;
import br.com.fiap.levelAI.beans.Disciplina;
import br.com.fiap.levelAI.excecao.InvalidValue;

public class DisciplinaBO {

    /*
    VERIFICAR STATUS, NAO SEI COMO TRATAR
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
