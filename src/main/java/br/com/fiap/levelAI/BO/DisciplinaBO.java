package br.com.fiap.levelAI.BO;

import br.com.fiap.levelAI.DAO.DisciplinaDAO;
import br.com.fiap.levelAI.beans.Disciplina;
import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.excecao.InvalidValue;

/**
 * Esta classe tem como finalidade validar as Disciplinas do LevelAi
 * 
 * @author patricia
 * @author Nadia
 */
public class DisciplinaBO {

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
			if (objDisciplina.getNome().length() <= 0 || objDisciplina.getNome().length() > 20) {
				throw new InvalidValue("Nome invalido");
			}
			objDisciplina.setDescricao(objDisciplina.getDescricao().toUpperCase());
			if (objDisciplina.getDescricao().length() <= 0 || objDisciplina.getDescricao().length() >= 100) {
				throw new InvalidValue("Descricao invalida");
			}

			if (objDisciplina.getInicio().after(objDisciplina.getTermino())) {
				throw new InvalidValue("Data incorreta");
			}

			dao = new DisciplinaDAO();
			Disciplina disciplinaCodigo = dao.getDisciplina(objDisciplina.getCodigo());
			if (disciplinaCodigo.getCodigo() > 0) {
				throw new InvalidValue("Codigo ja existe");
			}

			if (dao.addDisciplina(objDisciplina) == 0) {
				throw new InvalidValue("Disciplina nao cadastrada");
			} else {
				System.out.println("Disciplina cadastrada");
			}
		} catch (InvalidValue i) {
			System.out.println(i.getMessage());
		} finally {
			Conexao.fechar();
		}
	}
}