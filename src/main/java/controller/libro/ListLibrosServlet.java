package controller.libro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Libro;
import services.LibroService;

@WebServlet("/libros/libros.do")

public class ListLibrosServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	LibroService lService;

	@Override
	public void init() throws ServletException {
		super.init();
		lService= new LibroService(); //esto lo hacemos para las ofertas en el tp

	}

	//si entra logueado hace esto
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userL = (String) req.getSession().getAttribute("user");
		List<Libro> libros = null;
		try {
			libros=lService.findLibrosByUser(userL); //aca busco los libros de ese usuario
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//para mostrarlos en pantalla
		req.setAttribute("libros", libros);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/libros/libros.jsp");
		dispatcher.forward(req, resp);
	}
}
