package br.com.fiap.levelAI.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection getConectar() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@banco.fiap.com.br:1521:ORCL", "RM81830", "070791");
	}
}