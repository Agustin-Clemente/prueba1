package persistence.commons;
import persistence.LibroDAO;
import persistence.UserDAO;

public class DAOFactory {
	public static UserDAO getUserDAO() {
		return new UserDAO();
	}
	public static LibroDAO getLibroDAO() {
		return new LibroDAO();
	}

}
