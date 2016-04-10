package repository;

import java.util.ArrayList;
import java.util.List;

import model.CartItem;
import model.PizzaModel;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CartItems {
	
	private List<CartItem> cartItems;

	public CartItems(Integer userId) {
		cartItems = new ArrayList<>();
		Session session = PizzaShopDatabaseClient.getSession();
		BoundStatement statement = session
			.prepare("SELECT * FROM pizzashop.cartItems WHERE userId = ?")
			.bind(userId);
		ResultSet results = session.execute(statement);
		for (Row row : results) {
			cartItems.add(new CartItem(row.getInt("id"), row.getInt("pizzaId"), row.getString("pizzaName")));
		}
	}

	public List<CartItem> asList() {
		return cartItems;
	}
	
	public static void addItem(Integer userId, Integer pizzaId) {
		Session session = PizzaShopDatabaseClient.getSession();
		PizzaModel pizza = Pizzas.findById(pizzaId);
		BoundStatement boundStatement = session
				.prepare("insert into pizzashop.cartItems (id, pizzaId, pizzaName, userId) values (?, ?, ?, ?)")
				.bind((int) (Math.random() * 10000), pizzaId, pizza.getName(), userId);
		session.execute(boundStatement);
	}
	
}
