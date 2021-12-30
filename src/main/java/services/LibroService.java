package services;

import java.sql.SQLException;
import java.util.List;

import models.Libro;
import persistence.commons.DAOFactory;
import utils.Ordenador;

public class LibroService { //interactua con base de datos

	public List<Libro> findLibrosByUser(String userL) throws SQLException {
	
		List <Libro> libros= DAOFactory.getLibroDAO().findLibrosByUserName(userL);
		libros.sort(new Ordenador());
		return libros;
	}

}
