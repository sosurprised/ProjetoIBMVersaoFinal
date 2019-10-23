package br.com.fiap.levelAI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import br.com.fiap.levelAI.beans.Aluno;
import br.com.fiap.levelAI.conexao.Conexao;

/**
 * Esta classe é responsável pelo CRUD de um aluno do LevelAi
 * 
 * @author patricia
 * @author nadia
 */
public class AlunoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Este construtor conecta com o banco de dados
	 * 
	 * @throws Exception
	 */
	public AlunoDAO() throws Exception {
		con = Conexao.getConectar();
	}

	/**
	 * Este método é responsavel por adicionar aluno no banco de dados
	 * 
	 * @param aluno - recebe um objeto do tipo aluno
	 * @return - retorna a quantidade de colunas alteradas no banco de dados
	 * @throws Exception - Lançado quando acontecer uma exceção
	 */
	public int addAluno(Aluno aluno) throws Exception {
		int executeUpdate = 0;
		try {
			stmt = con.prepareStatement(
					"insert into t_sd_aluno (cd_aluno, nm_nome, ds_endereco, nr_telefone, dt_nascimento, ds_email, ds_senha) VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, aluno.getCodigo());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getEndereco());
			stmt.setString(4, aluno.getTelefone());
			stmt.setDate(5, new Date(aluno.getDataNascimento().getTime()));
			stmt.setString(6, aluno.getEmail());
			stmt.setString(7, aluno.getSenha());
			executeUpdate = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return executeUpdate;
	}

	/**
	 * Este método é responsável por deletar alunos no banco de dados
	 * 
	 * @param codigo - recebe um id do tipo inteiro
	 * @return - retorna uma string informando se o aluno foi ou não deletado
	 * @throws Exception - Lançado de acontecer alguma exceção
	 */
	public String deleteAluno(int codigo) throws Exception {
		String mensagem = null;
		try {
			stmt = con.prepareStatement("delete from t_sd_aluno where cd_aluno=?");
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
	 * Este método é responsável por alterar o aluno no banco de dados
	 * 
	 * @param aluno - recebe um objeto do tipo aluno
	 * @return - retorna a quantidade de colunas alteradas no banco de dados
	 * @throws Exception - é lançado quando acontece uma exceção
	 */
	public int updateAluno(Aluno aluno) throws Exception {
		int executeUpdate = 0;
		try {
			stmt = con.prepareStatement(
					"update t_sd_aluno set nm_nome=?, ds_endereco=?, nr_telefone=?, dt_nascimento=?, ds_email=?, ds_senha=? where cd_aluno=?");

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEndereco());
			stmt.setString(3, aluno.getTelefone());
			stmt.setDate(4, new Date(aluno.getDataNascimento().getTime()));
			stmt.setString(5, aluno.getEmail());
			stmt.setString(6, aluno.getSenha());
			stmt.setInt(7, aluno.getCodigo());

			executeUpdate = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return executeUpdate;
	}

	/**
	 * Este método é responsável por buscar um aluno pelo id
	 * 
	 * @param codigo - recebe um id do tipo inteiro
	 * @return - retorna um objeto Aluno
	 * @throws Exception - é lançado quando acontece alguma exceção
	 */
	public Aluno getAluno(int codigo) throws Exception {
		try {
			stmt = con.prepareStatement("select * from t_sd_aluno where cd_aluno=?");
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new Aluno(rs.getInt("cd_aluno"), rs.getString("nm_nome"), rs.getString("ds_endereco"),
						rs.getString("nr_telefone"), rs.getDate("dt_nascimento"), rs.getString("ds_email"),
						rs.getString("ds_senha"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return new Aluno();
	}

}