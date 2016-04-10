package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.CartItems;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

	private static final long serialVersionUID = 390819157893539334L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pizzaId = req.getParameter("id");
		CartItems.addItem((Integer) req.getSession().getAttribute("userId"), Integer.valueOf(pizzaId));
		resp.sendRedirect("/CDN/cart");
	}
	
}
