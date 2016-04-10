package model;

public class CartItem {

	private Integer id;
	private Integer pizzaId;
	private String pizzaName;

	public CartItem(Integer id, Integer pizzaId, String pizzaName) {
		this.id = id;
		this.setPizzaId(pizzaId);
		this.setPizzaName(pizzaName);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
}
