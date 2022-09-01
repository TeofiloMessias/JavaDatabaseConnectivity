package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner (System.in);		
		
		System.out.print("Infomr o código da pessoa: ");
		int codigo = entrada.nextInt();
		
		String select = "SELECT * FROM codigo, nome pessoas WHERE codigo = ?";
		String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		
		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(select);
		stmt.setInt(1, codigo);
		ResultSet resultado = stmt.executeQuery();
		
		if(resultado.next()) {
			Pessoa pessoa = new Pessoa(resultado.getInt(1), resultado.getString(2));
			System.out.println("O nome atual é " +  pessoa.getNome());
			
			System.out.print("Infomr o novo nome: ");
			String novoNome = entrada.nextLine();
						
			stmt.close();
			stmt = conexao.prepareStatement(update);
			stmt.setString(1, novoNome);
			stmt.setInt(1, codigo);
			stmt.execute();
		}else {
			System.out.print("Pessoa não encontrada");
		}
		conexao.close();
		entrada.close();		
	}

}
