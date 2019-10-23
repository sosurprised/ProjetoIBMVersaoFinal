package br.com.fiap.levelAI.BO;

import br.com.fiap.levelAI.DAO.AlunoDAO;
import br.com.fiap.levelAI.beans.Aluno;
import br.com.fiap.levelAI.excecao.InvalidValue;

public class AlunoBO {
    /*

    Verificar menor quantidade dos atributoss
    criar check para nascimento

*/

public void novoAluno(Aluno objAluno) throws Exception {
    AlunoDAO dao = null;
    try {
        objAluno.setEmail(objAluno.getEmail().toUpperCase());
        if (objAluno.getEmail().length() < 10 || objAluno.getEmail().length() > 60) {
            throw new InvalidValue("Email inv�lido");
        }
        objAluno.setEndereco(objAluno.getEndereco().toUpperCase());
        if (objAluno.getEndereco().length() <= 0 || objAluno.getEndereco().length() >= 30) {
            throw new InvalidValue("Endere�o inv�lido");
        }

        objAluno.setNome(objAluno.getNome().toUpperCase());
        if (objAluno.getNome().length() <= 0 || objAluno.getNome().length() > 60) {
            throw new InvalidValue("Nome inv�lido");
        }

        objAluno.setSenha(objAluno.getSenha());
        if (objAluno.getSenha().length() <= 0 || objAluno.getSenha().length() > 15) {
            throw new InvalidValue("Senha inv�lida");
        }
        dao = new AlunoDAO();
        Aluno alunoCodigo = dao.getAluno(objAluno.getCodigo());
        if (alunoCodigo.getCodigo() > 0) {
                throw new InvalidValue("C�digo j� existe");
        }
        if (dao.addAluno(objAluno) == 0) {
            throw new InvalidValue("Aluno n�o cadastrado");
        } else {
        	System.out.println("Aluno cadastrado");
            }
        } catch (InvalidValue i) {
            System.out.println(i.getMessage());
        } finally {
            dao.fechar();
        }
    }
}
