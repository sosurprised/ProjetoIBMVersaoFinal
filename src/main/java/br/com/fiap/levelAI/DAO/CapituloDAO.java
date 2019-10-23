package br.com.fiap.levelAI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.levelAI.beans.Capitulo;
import br.com.fiap.levelAI.conexao.Conexao;

/**
 * Esta classe é responsavel por fazer o CRUD de um capitulo do LevelAi
 * 
 * @author patricia
 * @author nadia
 */
public class CapituloDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Este construtor abre conexão com o banco de dados
	 * 
	 * @throws Exception - Lançado quando acontece uma exceção
	 */
	public CapituloDAO() throws Exception {
		con = Conexao.getConectar();
	}

	/**
	 * Este método é responsável por adicionar um capitulo ao banco de dados
	 * 
	 * @param capitulo - recebe um objeto do tipo capitulo
	 * @return - retorna a quantidade de colunas alteradas no capitulo
	 * @throws Exception - é lançado quando acontece uma exceção
	 */
	public int addCapitulo(Capitulo capitulo) throws Exception {
		int executeUpdate = 0;
		try {
			stmt = con.prepareStatement("insert into t_sd_capitulo (cd_capitulo, cd_disciplina, ds_titulo, ds_conteudo)"
					+ " VALUES (?, ?, ?, ?)");
			stmt.setInt(1, capitulo.getCodigo());
			stmt.setInt(2, capitulo.getDisciplinaCapitulo().getCodigo());
			stmt.setString(3, capitulo.getTitulo());
			stmt.setString(4, capitulo.getConteudo());

			executeUpdate = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return executeUpdate;
	}

	/**
	 * Este método é responsavel por apagar os capitulos do banco de dados
	 * 
	 * @param codigo - recebe um id do tipo inteiro
	 * @return - retorna uma String informando se foi ou não deletado
	 * @throws Exception - Lançado quand acontece uma exceção
	 */
	public String deleteCapitulo(int codigo) throws Exception {
		stmt = con.prepareStatement("delete from t_sd_capitulo where cd_capitulo=?");
		stmt.setInt(1, codigo);
		if (stmt.executeUpdate() > 0) {
			return "Deletado com sucesso";
		} else {
			return "Cap�tulo n�o encontrado";
		}
	}

	/**
	 * Este método é responsável por alterar o capitulo no banco de dados
	 * 
	 * @param capitulo - recebe um objeto do tipo capitulo
	 * @return - rtorna a quantidade de colunas alterada no capitulo
	 * @throws Exception - Lançado quando acontece uma exceção
	 */
	public int updatecapitulo(Capitulo capitulo) throws Exception {
		int executeUpdate = 0;
		try {
			stmt = con.prepareStatement(
					"update t_sd_capitulo set cd_disciplina=?, ds_titulo=?, ds_conteudo=? where cd_capitulo=?");

			stmt.setInt(1, capitulo.getDisciplinaCapitulo().getCodigo());
			stmt.setString(2, capitulo.getTitulo());
			stmt.setString(3, capitulo.getConteudo());
			stmt.setInt(4, capitulo.getCodigo());

			executeUpdate = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return executeUpdate;
	}

	/**
	 * Este método é responsável por buscar um capitulo pelo Id
	 * 
	 * @param codigo - recebe um id do tipo inteiro
	 * @return - retorna um objeto do tipo capitulo
	 * @throws Exception - Lançado quando acontece uma exceção
	 */
	public Capitulo getCapitulo(int codigo) throws Exception {
		Capitulo capitulo = null;
		try {
			DisciplinaDAO dao = new DisciplinaDAO();
			stmt = con.prepareStatement("select * from t_sd_capitulo where cd_capitulo=?");
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				capitulo = new Capitulo(rs.getInt("cd_capitulo"), dao.getDisciplina(rs.getInt("cd_disciplina")),
						rs.getString("ds_titulo"), rs.getString("ds_conteudo"));
			} else {
				capitulo = new Capitulo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return capitulo;
	}

}
