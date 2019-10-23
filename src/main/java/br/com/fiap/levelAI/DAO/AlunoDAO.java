package br.com.fiap.levelAI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.levelAI.beans.Aluno;
import br.com.fiap.levelAI.conexao.Conexao;

public class AlunoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public AlunoDAO() throws Exception {
		con = Conexao.getConectar();
	}

	public Aluno getAluno(int codigo) throws Exception {
		stmt = con.prepareStatement("select * from t_sd_aluno where cd_aluno=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Aluno(rs.getInt("cd_aluno"), rs.getString("nm_nome"), rs.getString("ds_endereco"),
					rs.getString("nr_telefone"), rs.getString("dt_nascimento"), rs.getString("ds_email"),
					rs.getString("ds_senha"));
		} else {
			return new Aluno();
		}
	}

	public String apagarAluno(int codigo) throws Exception {
		try {
			stmt = con.prepareStatement("delete from t_sd_aluno where cd_aluno=?");
			stmt.setInt(1, codigo);
			if (stmt.executeUpdate() > 0) {
				return "Deletado com sucesso";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fechar();
		}
		return "Aluno não encontrado";
	}

	public int addAluno(Aluno obj) throws Exception {
		int res = 0;
		try {
			stmt = con.prepareStatement(
					"insert into t_sd_aluno (cd_aluno, nm_nome, ds_endereco, nr_telefone, dt_nascimento, ds_email, ds_senha) VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, obj.getCodigo());
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getEndereco());
			stmt.setString(4, obj.getTelefone());
			stmt.setString(5, obj.getDataNascimento());
			stmt.setString(6, obj.getEmail());
			stmt.setString(7, obj.getSenha());
			res =  stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fechar();
		}
		return res;
	}

	public void fechar() throws Exception {
		con.close();
	}

	public Aluno getEmailAluno(String email, String senha) throws Exception {
		stmt = con.prepareStatement("select * from t_sd_aluno where ds_email=? and ds_senha=?");
		stmt.setString(1, email);
		stmt.setString(2, senha);
		rs = stmt.executeQuery();
		if (rs.next()) {
				return new Aluno(rs.getInt("cd_aluno"), rs.getString("nm_nome"), rs.getString("ds_endereco"),
						rs.getString("nr_telefone"), rs.getString("dt_nascimento"), rs.getString("ds_email"),
						rs.getString("ds_senha"));		
		}
		else {
			return new Aluno();
		}
	}
}
