package br.com.fiap.levelAI.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import br.com.fiap.levelAI.beans.Matricula;
import br.com.fiap.levelAI.conexao.Conexao;

public class MatriculaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public MatriculaDAO() throws Exception{
		con = Conexao.getConectar();
	}
	
	public Matricula getMatricula(int codigo) throws Exception{
		DisciplinaDAO daoD = new DisciplinaDAO();
		AlunoDAO daoA = new AlunoDAO();
		stmt = con.prepareStatement
		("select * from t_sd_matricula where cd_matricula=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Matricula(
					rs.getInt("cd_matricula"),
					daoD.getDisciplina(rs.getInt("cd_disciplina")),
					daoA.getAluno(rs.getInt("cd_aluno")),
					rs.getDate("dt_matricula")
					);
		}else {
			return new Matricula();
		}
	}
	
	public String apagarMatricula(int codigo) throws Exception{
		stmt = con.prepareStatement
		("delete from t_sd_matricula where cd_matricula=?");
		stmt.setInt(1, codigo);
		if (stmt.executeUpdate()>0) {
			return "Deletado com sucesso";
		}else {
			return "Matricula n�o encontrada";
		}
	}
	
	public int addMatricula(Matricula obj) throws Exception{
		stmt = con.prepareStatement
				("insert into t_sd_matricula (cd_matricula, cd_disciplina, cd_aluno, dt_matricula)"
						+ " VALUES (?, ?, ?, ?)");
		stmt.setInt(1, obj.getCodigo());
		stmt.setInt(2, obj.getDisciplina().getCodigo());
		stmt.setInt(3, obj.getAluno().getCodigo());
		stmt.setDate(4, new Date(obj.getDataMatricula().getTime()));		return stmt.executeUpdate();
	}
	
	public void fechar() throws Exception {
		con.close();
	}
}

