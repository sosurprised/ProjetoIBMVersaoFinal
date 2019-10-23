package br.com.fiap.levelAI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.beans.Admin;

/**
 * Esta classe tem como finalidade fazer o CRUD de um Administrador do LevelAI
 * 
 * @author patricia
 * @author Nadia
 * 
 */
public class AdminDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * este construtor conecta com o banco de dados
	 * 
	 * @throws Exception
	 */
	public AdminDAO() throws Exception {
		con = Conexao.getConectar();
	}

	/**
	 * Este método adiciona um administrador no banco de dados
	 * 
	 * @param obj - recebe um objeto do tipo Admin
	 * @return - retorna o numero de linhas alteradas
	 * @throws Exception - é lancado quando acontecer uma exceção
	 */
	public int addAdmin(Admin obj) throws Exception {
		int executeUpdate = 0;
		try {
			stmt = con.prepareStatement(
					"insert into t_sd_admin (cd_admin, nm_admin, ds_email, ds_senha)" + " VALUES (?, ?, ?, ?)");

			stmt.setInt(1, obj.getCodigo());
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getEmail());
			stmt.setString(4, obj.getSenha());

			executeUpdate = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return executeUpdate;
	}

	/**
	 * Este metodo apaga um administrador do banco de dados
	 * 
	 * @param codigo - recebe um id do tipo inteiro
	 * @return - retorna uma String informando se foi ou não deletado
	 * @throws Exception - é lançada se acontecer uma exceção
	 */
	public String deleteAdmin(int codigo) throws Exception {
		String mensagem = null;
		try {
			stmt = con.prepareStatement("delete from t_sd_admin where cd_admin=?");
			stmt.setInt(1, codigo);
			if (stmt.executeUpdate() > 0) {
				mensagem = "Deletado com sucesso";
			} else {
				mensagem = "Admin não encontrado";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return mensagem;
	}

	/**
	 * Este metodo altera um administrador no banco de dados
	 * 
	 * @param admin - rece um objeto do tipo admin
	 * @return - retorna a quantidade de linhas alteradas
	 * @throws Exception - É lançada se acontecer uma exceção
	 */
	public int updateAdmin(Admin admin) throws Exception {
		int executeUpdate = 0;
		int codigo = admin.getCodigo();
		try {
			stmt = con.prepareStatement("update t_sd_admin set nm_nome=?, ds_email=?, ds_senha=? where cd_aluno=?");

			stmt.setString(1, admin.getNome());
			stmt.setString(2, admin.getEmail());
			stmt.setString(3, admin.getSenha());
			stmt.setInt(4, admin.getCodigo());

			executeUpdate = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return executeUpdate;
	}

	/**
	 * este método pega os dados de um administrador do banco de dados
	 * 
	 * @param codigo - recebe um id do tipo inteiro
	 * @return - retorna um objeto Admin
	 * @throws Exception - é lançado quando acontecer uma exceção
	 */
	public Admin getAdmin(int codigo) throws Exception {
		Admin admin = null;
		try {
			stmt = con.prepareStatement("select * from t_sd_admin where cd_admin=?");
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				admin = new Admin(rs.getInt("cd_admin"), rs.getString("nm_admin"), rs.getString("ds_email"),
						rs.getString("ds_senha"));
			} else {
				admin = new Admin();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return admin;
	}
}
