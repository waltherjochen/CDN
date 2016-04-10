package model;

import java.io.Serializable;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 2543879975731116077L;

	private Integer id;
	private String username;

	public UserModel(Integer id, String username) {
		this.setId(id);
		this.setUsername(username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
