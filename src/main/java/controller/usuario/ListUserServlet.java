package controller.usuario;

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
import models.Usuario;
import services.UserService;

@WebServlet("/usuarios/usuarios.do")

public class ListUserServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> usuarios = null;

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuarios/usuarios.jsp");
		dispatcher.forward(req, resp);
	}
}
