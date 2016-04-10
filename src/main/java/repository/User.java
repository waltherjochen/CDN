package repository;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;


public class User {
	public static boolean exists(String username, String password) {
		BoundStatement boundStatement = PizzaShopDatabaseClient.getSession().prepare(
			"SELECT * FROM pizzashop.users WHERE username = ? AND password = ? ALLOW FILTERING"
			)
			.bind(username, password);
		ResultSet resultSet = PizzaShopDatabaseClient.getSession().execute(boundStatement);
		return resultSet.all().size() > 0;
	}

}
