package br.com.mvc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mvc.models.Usuario;

public class UsuarioDAO {
	private Connection con;
	
    public UsuarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean existeUsuario(Usuario usr){
    	
    	String sql = "select * from usuarios where login = ? and senha = ?";
    	
		if (usr == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}

		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, usr.getLogin());
			stmt.setString(2, usr.getSenha());
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = rs.next();
			rs.close();
			stmt.close();

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
}
    }
}
