package br.com.fiap.levelAI.BO;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.levelAI.DAO.AlunoDAO;
import br.com.fiap.levelAI.beans.Aluno;
import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.excecao.InvalidValue;

/**
 * Esta classe tem como finalidade validar os Alunos do levelAi
 * 
 * @author patricia
 * @author Nadia
 */
public class AlunoBO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Este metódo valida: Nome, email, endereco, senha e id de um novo Aluno do
	 * LevelAi
	 * 
	 * @author patricia
	 * @author Nadia
	 * @param objAluno - Recebe um objeto do tipo Aluno
	 * @throws Exception    - é lançado quando acontecer alguma exceção
	 * @throws InvalidValue - é lançado quando o valor dos atributos verificados
	 *                      pelo método tiver um valor inválido
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
				throw new InvalidValue("Endereco invalido");
			}

			objAluno.setNome(objAluno.getNome().toUpperCase());
			if (objAluno.getNome().length() <= 0 || objAluno.getNome().length() > 60) {
				throw new InvalidValue("Nome invalido");
			}
			if (objAluno.getTelefone().length() > 15) {
				throw new InvalidValue("Telefone inválido");
			}
			if (objAluno.getDataNascimento().after(new Date())) {
				throw new InvalidValue("Data de nascimento inválida");
			}
			objAluno.setSenha(objAluno.getSenha());
			if (objAluno.getSenha().length() <= 0 || objAluno.getSenha().length() > 15) {
				throw new InvalidValue("Senha invalida");
			}
			dao = new AlunoDAO();
			Aluno alunoCodigo = dao.getAluno(objAluno.getCodigo());
			if (alunoCodigo.getCodigo() > 0) {
				throw new InvalidValue("Codigo ja existe");
			}
			if (dao.addAluno(objAluno) == 0) {
				throw new InvalidValue("Aluno nao cadastrado");
			} else {
				System.out.println("Aluno cadastrado");
			}
		} catch (InvalidValue i) {
			System.out.println(i.getMessage());
		} finally {
			Conexao.fechar();
		}
	}

	/**
	 * Este método tem como finalidade consultar se um email e senha existe no banco
	 * de dados
	 * 
	 * @param email - recebe um email
	 * @param senha - recebe uma senha
	 * @return - retorna um novo aluno se o email e senha for valido
	 * @throws Exception - é lançado quando acontecer uma exceção
	 */
	public Aluno validarEmailESenha(String email, String senha) throws Exception {
		stmt = con.prepareStatement("select * from t_sd_aluno where ds_email=? and ds_senha=?");
		stmt.setString(1, email);
		stmt.setString(2, senha);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Aluno(rs.getInt("cd_aluno"), rs.getString("nm_nome"), rs.getString("ds_endereco"),
					rs.getString("nr_telefone"), rs.getDate("dt_nascimento"), rs.getString("ds_email"),
					rs.getString("ds_senha"));
		} else {
			return new Aluno();
		}
	}
}
