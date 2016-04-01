package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.PizzasInformation;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 6604427438347317884L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		getServletContext().getRequestDispatcher("/loginPage.jsp").forward(req, resp);
	};

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username.equals("user") && password.equals("pass")) {
			req.getSession().setAttribute("username", "user");
			resp.sendRedirect("/CDN");
		}
	}

}
