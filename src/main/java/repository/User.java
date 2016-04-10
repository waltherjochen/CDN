package repository;

import java.util.List;

import model.UserModel;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;


public class User {
	public static Integer attemptLogin(String username, String password) {
		Session session = PizzaShopDatabaseClient.getSession();
		BoundStatement boundStatement = session.prepare(
			"SELECT * FROM pizzashop.users WHERE username = ? AND password = ? ALLOW FILTERING"
			)
			.bind(username, password);
		ResultSet resultSet = session.execute(boundStatement);
		List<Row> all = resultSet
				.all();
		return all.size() > 0 ? all.get(0).getInt("id") : null;
	}
	
	public static UserModel findById(Integer id) {
		Session session = PizzaShopDatabaseClient.getSession();
		BoundStatement boundStatement = session.prepare(
			"SELECT * FROM pizzashop.users WHERE id = ?"
			)
			.bind(id);
		ResultSet result = session.execute(boundStatement);
		List<Row> all = result.all();
		if (all.size() > 0) {
			Integer userId = all.get(0).getInt("id");
			String username = all.get(0).getString("username");
			return new UserModel(userId, username);
		}
		return null;
	}

}
