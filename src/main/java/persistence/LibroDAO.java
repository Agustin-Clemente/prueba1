package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Libro;
import models.Usuario;
import persistence.commons.ConnectionProvider;

public class LibroDAO {
	public List<Libro> findLibrosByUserName(String nombre) throws SQLException{
		List<Libro> libros = new ArrayList<Libro>();
		String sql = "select * from Libros where usuario_nombre=?";
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, nombre);
		ResultSet res = st.executeQuery();
		while(res.next()) {
			libros.add( new Libro(res.getString(2), res.getString(3),res.getString(4),res.getString(5),res.getInt(6)));
		}
		return libros;
	}

}
