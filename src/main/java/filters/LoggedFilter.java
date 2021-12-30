package filters;
import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "*.do")
public class LoggedFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String user = (String) ((HttpServletRequest) request).getSession().getAttribute("user"); //pide identificacion
		if (user != null) {
			chain.doFilter(request, response); //si esta logueado sigue
		} else {
			request.setAttribute("flash", "Por favor, ingresa al sistema");
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp"); //sino vuelve al login
			dispatcher.forward(request, response);
		}
	}

}