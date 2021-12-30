package controller.session;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Usuario;
import persistence.UserDAO;
import persistence.commons.DAOFactory;
import services.UserService;

@WebServlet("/login") //aca viene del login.jsp
public class LoginServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	UserService uService; //servicio

	@Override
	public void init() throws ServletException { //inicializo servlet
		super.init();
		uService = new UserService(); //inicializo servicio
	}

	@Override //cuando viene del login hace esto
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		Usuario usuario = null;
		try {
			usuario= uService.findUserByName(username); //busca en base de datos
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (usuario != null) {
			req.getSession().setAttribute("user", username); //si pone nombre de usuario lo guarda en la sesion bajo esta variable el nombre username
			resp.sendRedirect("libros/libros.do"); //
		} else {//si no ingreso nada...
			req.setAttribute("flash", "Nombre de usuario incorrecto"); //pone un mensaje
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp); //redirecciona a pagina login.jsp
		}
	}
}
