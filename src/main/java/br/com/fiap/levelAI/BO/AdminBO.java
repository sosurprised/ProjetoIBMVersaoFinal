package br.com.fiap.levelAI.BO;

import br.com.fiap.levelAI.DAO.AdminDAO;
import br.com.fiap.levelAI.beans.Admin;
import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.excecao.InvalidValue;

/**
 * Esta classe tem como responsabilidade validar o administrador do LevelAi
 * 
 * @author patricia
 * @author Nadia
 *
 */
public class AdminBO {

	/**
	 * Este metódo valida: Nome, email, senha e id de um novo administrador do
	 * LevelAi
	 * 
	 * @author patricia
	 * @author Nadia
	 * @param objAdmin - Recebe um objeto do tipo Admin
	 * @throws Exception    - é lançado quando acontecer alguma exceção
	 * @throws InvalidValue - é lançado quando o valor dos atributos verificados
	 *                      pelo método tiver um valor inválido
	 * 
	 */
	public void novoAdmin(Admin objAdmin) throws Exception {
		AdminDAO dao = new AdminDAO();
		try {
			objAdmin.setNome(objAdmin.getNome().toUpperCase());
			if (objAdmin.getNome().length() <= 0 || objAdmin.getNome().length() > 60) {
				throw new InvalidValue("Nome invalido");
			}
			objAdmin.setEmail(objAdmin.getEmail().toUpperCase());
			if (objAdmin.getEmail().length() < 0 || objAdmin.getEmail().length() > 60) {
				throw new InvalidValue("Email invalido");
			}

			objAdmin.setSenha(objAdmin.getSenha());
			if (objAdmin.getSenha().length() <= 0 || objAdmin.getSenha().length() > 15) {
				throw new InvalidValue("Senha invalida");
			}

			Admin adminCodigo = dao.getAdmin(objAdmin.getCodigo());
			if (adminCodigo.getCodigo() > 0) {
				throw new InvalidValue("Codigo ja existe");
			}
			if (dao.addAdmin(objAdmin) == 0) {
				throw new InvalidValue("Admin nao cadastrado");
			} else {
				System.out.println("Admin cadastrado");
			}
		} catch (InvalidValue i) {
			System.out.println(i.getMessage());
		} finally {
			Conexao.fechar();
		}
	}
}
