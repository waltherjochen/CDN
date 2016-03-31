package model;

public class Pizza {
	public Pizza(String name, String ingredients) {
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

}
