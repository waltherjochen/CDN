package repository;

import java.util.ArrayList;
import java.util.List;

import model.PizzaModel;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;


public class Pizzas {
	private List<PizzaModel> pizzas;

	public Pizzas() {
		ResultSet results = PizzaShopDatabaseClient.getSession().execute("SELECT * FROM pizzashop.pizzas");
		List<PizzaModel> pizzas = new ArrayList<>();
		for (Row row : results) {
			pizzas.add(new PizzaModel(row.getInt("id"), row.getString("name"), row.getString("ingredients")));
		}
		this.pizzas = pizzas;
	}
	
	public static PizzaModel findById(Integer id) {
		Session session = PizzaShopDatabaseClient.getSession();
		BoundStatement statement = session
			.prepare("SELECT * FROM pizzashop.pizzas WHERE id = ?")
			.bind(id);
		ResultSet resultSet = session.execute(statement);
		Row row = resultSet.all().get(0);
		return new PizzaModel(row.getInt("id"), row.getString("name"), row.getString("ingredients"));
	}

	public List<PizzaModel> asList() {
		return pizzas;
	}

}
