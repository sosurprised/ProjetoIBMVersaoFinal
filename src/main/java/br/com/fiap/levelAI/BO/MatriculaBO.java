package br.com.fiap.levelAI.BO;

import java.util.Date;

import br.com.fiap.levelAI.beans.Matricula;
import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.excecao.InvalidValue;

public class MatriculaBO {

	public void novoMatricula(Matricula objMatricula) throws Exception {
		try {
			objMatricula.setCodigo(objMatricula.getCodigo());
			if (objMatricula.getCodigo() != 6) {
				throw new InvalidValue("codigo invalido");
			}
			objMatricula.setDisciplina(objMatricula.getDisciplina());
			if (objMatricula.getDisciplina().getCodigo() > 100 || objMatricula.getDisciplina().getCodigo() <= 0) {
				throw new InvalidValue("Disciplina invalida");
			}

			objMatricula.setAluno(objMatricula.getAluno());
			if (objMatricula.getAluno().getCodigo() <= 0 || objMatricula.getAluno().getCodigo() > 99999) {
				throw new InvalidValue("Codigo invalido");
			}

			if (objMatricula.getDataMatricula().after(new Date())) {
				throw new InvalidValue("Data invalida");
			}
		} catch (InvalidValue i) {
			System.out.println(i.getMessage());
		} finally {
			Conexao.fechar();
		}
	}
}
