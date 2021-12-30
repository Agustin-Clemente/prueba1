package services;

import java.sql.SQLException;
import java.util.List;

import models.Usuario;
import persistence.commons.DAOFactory;

public class UserService {

	public Usuario findUserByName(String username) throws SQLException {
		
		return DAOFactory.getUserDAO().findUserByName(username); //servicio interactua con DAO
	}

}
