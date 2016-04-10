package model;

import java.io.Serializable;

public class PizzaModel implements Serializable {

	private static final long serialVersionUID = 8237095585588948382L;

	private int id;

	public PizzaModel(int id, String name, String ingredients) {
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
	}

	private String name;
	private String ingredients;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
