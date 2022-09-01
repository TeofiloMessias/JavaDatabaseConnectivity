package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	public static void main(String[] args) throws SQLException {
			//final String url ="jdbc:mysql://localhost:3306verifyServerCertificate=false&useSSl=true";
		    //CRIANDO CONEXÃO COM BACO
			final String url ="jdbc:mysql://localhost:3306/curso_java?verifyServerCertificate=false&useSSl=true";
			final String usuario = "root";
			final String senha = "root";
			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			Statement stmt = conexao.createStatement();
			stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java2022");
			
			System.out.print("Banco criado com sucesso");
			conexao.close();
		}
	}
