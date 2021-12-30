package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Usuario;
import persistence.commons.ConnectionProvider;

public class UserDAO {
	public Usuario findUserByName(String nombre) throws SQLException {
		Usuario usuario = null;
		String sql = "select * from Usuarios where nombre=?";
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, nombre);
		ResultSet res = st.executeQuery();
		while(res.next()) {
			usuario= new Usuario(res.getString(2));
		}
		return usuario;
	}

	public List<Usuario> findUsers() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from Usuarios";
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement st= con.prepareStatement(sql);
		ResultSet res = st.executeQuery();
		while(res.next()) {
			usuarios.add( new Usuario(res.getString(2)));
		}
		return usuarios;
	}

}
