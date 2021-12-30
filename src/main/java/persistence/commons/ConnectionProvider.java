package persistence.commons;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider { //va la ruta completa aca en url
	private static String url="jdbc:sqlite:D:\\usuarios\\alumno\\escritorio\\CURSOS\\#yoprogramo\\JAVA Hechos en clase\\Libreria\\libreria.db";
	private static Connection connection;
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC"); //levanta en memoria el controlador para levantar la base de datos en linea
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		if (connection == null) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
	}
}
