package br.com.fiap.levelAI.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.levelAI.conexao.Conexao;
import br.com.fiap.levelAI.beans.Capitulo;

public class CapituloDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public CapituloDAO() throws Exception{
		con = Conexao.getConectar();
	}
	
	public Capitulo getCapitulo(int codigo) throws Exception{
		DisciplinaDAO dao = new DisciplinaDAO();
		stmt = con.prepareStatement
		("select * from t_sd_capitulo where cd_capitulo=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Capitulo(
					rs.getInt("cd_capitulo"),
					dao.getDisciplina(rs.getInt("cd_disciplina")),
					rs.getString("ds_titulo"),
					rs.getString("ds_conteudo")
					);
		}else {
			return new Capitulo();
		}
	}
	
	public String apagarCapitulo(int codigo) throws Exception{
		stmt = con.prepareStatement
		("delete from t_sd_capitulo where cd_capitulo=?");
		stmt.setInt(1, codigo);
		if (stmt.executeUpdate()>0) {
			return "Deletado com sucesso";
		}else {
			return "Cap�tulo n�o encontrado";
		}
	}
	
	public int addCapitulo(Capitulo obj) throws Exception{
		stmt = con.prepareStatement
				("insert into t_sd_capitulo (cd_capitulo, cd_disciplina, ds_titulo, ds_conteudo)"
						+ " VALUES (?, ?, ?, ?)");
		stmt.setInt(1, obj.getCodigo());
		stmt.setInt(2, obj.getDisciplinaCapitulo().getCodigo());
		stmt.setString(3, obj.getTitulo());
		stmt.setString(4, obj.getConteudo());
		return stmt.executeUpdate();
	}
	
	public void fechar() throws Exception {
		con.close();
	}
	
}



