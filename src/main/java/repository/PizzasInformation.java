package repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Pizza;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;


public class PizzasInformation {
	private List<Pizza> pizzas;

	public PizzasInformation() {
		ResultSet results = PizzaShopDatabaseClient.getSession().execute("SELECT * FROM pizzashop.pizzas");
		List<Pizza> pizzas = new ArrayList<>();
		for (Row row : results) {
			pizzas.add(new Pizza(row.getString("name"), row.getString("ingredients")));
		}
		this.pizzas = pizzas;
	}

	public List<Pizza> asList() {
		return pizzas;
	}

}
