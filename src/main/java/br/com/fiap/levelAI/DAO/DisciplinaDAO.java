package br.com.fiap.levelAI.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.levelAI.beans.Disciplina;
import br.com.fiap.levelAI.conexao.Conexao;

/**
 * Esta classe é responsavel por fazer um CRUD de uma disciplina do LevelAi
 * 
 * @author patricia
 * @author nadia
 */
public class DisciplinaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * este construtor faz uma conexão com o banco
	 * 
	 * @throws Exception
	 */
	public DisciplinaDAO() throws Exception {
		con = Conexao.getConectar();
	}

	/**
	 * Este método adiciona uma disciplina ao banco
	 * 
	 * @param disciplina - recebe um objeto do tipo disciplina
	 * @return - retorna a quantidade de colunas alteradas na disciplina
	 * @throws Exception - Lançado quando acontece uma exceção
	 */
	public int addDisciplina(Disciplina disciplina) throws Exception {
		stmt = con.prepareStatement(
				"insert into t_sd_disciplina (cd_disciplina, nm_disciplina, ds_disciplina, dt_inicio, dt_termino, st_disciplina)"
						+ " VALUES (?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, disciplina.getCodigo());
		stmt.setString(2, disciplina.getNome());
		stmt.setString(3, disciplina.getDescricao());
		stmt.setDate(4, new Date(disciplina.getInicio().getTime()));
		stmt.setDate(5, new Date(disciplina.getTermino().getTime()));
		stmt.setBoolean(6, disciplina.getStatus());
		return stmt.executeUpdate();
	}

	/**
	 * Este método é responsavel por deletar uma disciplina no banco
	 * 
	 * @param codigo - recebe um id do tipo inteiro
	 * @return - retorna uma string informando se a disciplina foi ou não deletada
	 * @throws Exception - Lançado quando acontece uma exceção
	 */
	public String deleteDisciplina(int codigo) throws Exception {
		String mensagem = null;
		try {
			stmt = con.prepareStatement("delete from t_sd_disciplina where cd_disciplina=?");
			stmt.setInt(1, codigo);
			if (stmt.executeUpdate() > 0) {
				mensagem = "Deletado com sucesso";
			} else {
				mensagem = "disciplina não encontrado";
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
	public int updatedisciplina(Disciplina disciplina) throws Exception {
		int executeUpdate = 0;
		try {
			stmt = con.prepareStatement(
					"update t_sd_disciplina set nm_disciplina=?, ds_disciplina=?, dt_inicio=?, dt_termino=?, st_disciplina=? where cd_disciplina=?");

			stmt.setString(1, disciplina.getNome());
			stmt.setString(2, disciplina.getDescricao());
			stmt.setDate(3, new Date(disciplina.getInicio().getTime()));
			stmt.setDate(4, new Date(disciplina.getTermino().getTime()));
			stmt.setBoolean(5, disciplina.getStatus());
			stmt.setInt(6, disciplina.getCodigo());

			executeUpdate = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return executeUpdate;
	}

	/**
	 * Este metodo é responsavel por buscar uma disciplina por id no banco de dados
	 * 
	 * @param codigo - rece um id do tipo inteiro
	 * @return - retorna um objeto do tipo Disciplina
	 * @throws Exception - Lançado quando acontece uma exceção
	 */
	public Disciplina getDisciplina(int codigo) throws Exception {
		Disciplina disciplina = null;
		try {
			stmt = con.prepareStatement("select * from t_sd_disciplina where cd_disciplina=?");
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				disciplina = new Disciplina(rs.getInt("cd_disciplina"), rs.getString("nm_disciplina"),
						rs.getString("ds_disciplina"), rs.getDate("dt_inicio"), rs.getDate("dt_termino"),
						rs.getBoolean("st_disciplina"));
			} else {
				disciplina = new Disciplina();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return disciplina;
	}

}
