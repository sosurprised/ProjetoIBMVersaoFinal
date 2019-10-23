package br.com.fiap.levelAI.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.levelAI.beans.Matricula;
import br.com.fiap.levelAI.conexao.Conexao;

/**
 * Esta classe é responsavel por fazer o CRUD de uma matricula do LevelAi
 * 
 * @author nadia
 * @author patricia
 *
 */
public class MatriculaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Este construtor faz uma conexão com o banco de dados
	 * 
	 * @throws Exception - Lançado quando acontece uma exceção
	 */
	public MatriculaDAO() throws Exception {
		con = Conexao.getConectar();
	}

	/**
	 * Este metodo adiciona uma matricula ao banco de dados
	 * 
	 * @param matricula - recebe um objeto do tipo matricula
	 * @return - retorna a quantidade de colunas alteradas no banco de dados
	 * @throws Exception - Lançado quando acontece uma exceção
	 */
	public int addMatricula(Matricula matricula) throws Exception {
		int executeUpdate = 0;
		try {
			stmt = con
					.prepareStatement("insert into t_sd_matricula (cd_matricula, cd_disciplina, cd_aluno, dt_matricula)"
							+ " VALUES (?, ?, ?, ?)");
			stmt.setInt(1, matricula.getCodigo());
			stmt.setInt(2, matricula.getDisciplina().getCodigo());
			stmt.setInt(3, matricula.getAluno().getCodigo());
			stmt.setDate(4, new Date(matricula.getDataMatricula().getTime()));
			executeUpdate = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return executeUpdate;
	}

	/**
	 * Esse método é responsavel por deletar uma mstricula no banco de dados
	 * 
	 * @param codigo - recebe um is do tipo inteiro
	 * @return - retorna uma mensagem informando se foi ou nao deletado
	 * @throws Exception - Lançado quando acontece uma exceção
	 */
	public String deleteMatricula(int codigo) throws Exception {
		String mensagem = null;
		try {
			stmt = con.prepareStatement("delete from t_sd_matricula where cd_matricula=?");
			stmt.setInt(1, codigo);
			if (stmt.executeUpdate() > 0) {
				mensagem = "Deletado com sucesso";
			} else {
				mensagem = "Matricula n�o encontrada";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return mensagem;
	}

	/**
	 * Este metodo altera uma disciplina no banco de dados
	 * 
	 * @param disciplina - rece um disciplinaeto do tipo disciplina
	 * @return - retorna a quantidade de linhas alteradas
	 * @throws Exception - É lançada se acontecer uma exceção
	 */
	public int updateMatricula(Matricula matricula) throws Exception {
		int executeUpdate = 0;
		try {
			stmt = con.prepareStatement(
					"update t_sd_matricula set cd_disciplina=?, cd_aluno=?, dt_matricula=? where cd_matricula=?");

			stmt.setInt(1, matricula.getDisciplina().getCodigo());
			stmt.setInt(2, matricula.getAluno().getCodigo());
			stmt.setDate(3, new Date(matricula.getDataMatricula().getTime()));
			stmt.setInt(4, matricula.getCodigo());

			executeUpdate = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return executeUpdate;
	}

	/**
	 * Este metodo é responsavel por buscar uma matricula por id no banco de dados
	 * 
	 * @param codigo - rece um id do tipo inteiro
	 * @return - retorna um objeto do tipo matricula
	 * @throws Exception - Lançado quando acontece uma exceção
	 */
	public Matricula getMatricula(int codigo) throws Exception {
		Matricula matricula = null;
		try {
			DisciplinaDAO daoD = new DisciplinaDAO();
			AlunoDAO daoA = new AlunoDAO();
			stmt = con.prepareStatement("select * from t_sd_matricula where cd_matricula=?");
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				matricula = new Matricula(rs.getInt("cd_matricula"), daoD.getDisciplina(rs.getInt("cd_disciplina")),
						daoA.getAluno(rs.getInt("cd_aluno")), rs.getDate("dt_matricula"));
			} else {
				matricula = new Matricula();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return matricula;
	}

}
