package br.com.fiap.levelAI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.beans.Disciplina;



public class DisciplinaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public DisciplinaDAO() throws Exception{
		con = Conexao.getConectar();
	}
	
	public Disciplina getDisciplina(int codigo) throws Exception{
		stmt = con.prepareStatement
		("select * from t_sd_disciplina where cd_disciplina=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Disciplina(
					rs.getInt("cd_disciplina"),
					rs.getString("nm_disciplina"),
					rs.getString("ds_disciplina"),
					rs.getString("dt_inicio"),
					rs.getString("dt_termino"),
					rs.getString("st_disciplina")	
					);
		}else {
			return new Disciplina();
		}
	}
	
	public String apagarDisciplina(int codigo) throws Exception{
		stmt = con.prepareStatement
		("delete from t_sd_disciplina where cd_disciplina=?");
		stmt.setInt(1, codigo);
		if (stmt.executeUpdate()>0) {
			return "Deletado com sucesso";
		}else {
			return "Disciplina não encontrada";
		}
	}
	
	public int addDisciplina(Disciplina obj) throws Exception{
		stmt = con.prepareStatement
				("insert into t_sd_disciplina (cd_disciplina, nm_disciplina, ds_disciplina, dt_inicio, dt_termino, st_disciplina)"
						+ " VALUES (?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, obj.getCodigo());
		stmt.setString(2, obj.getNome());
		stmt.setString(3, obj.getDescricao());
		stmt.setString(4, obj.getInicio());
		stmt.setString(5, obj.getTermino());
		stmt.setString(6, obj.getStatus());
		return stmt.executeUpdate();
	}
	
	public void fechar() throws Exception {
		con.close();
	}
	

}


