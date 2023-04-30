package serialization;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 4298294921403420069L;
	private int id;
	private String name;
	private boolean isSubscribed;
	private int x;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSubscribed() {
		return isSubscribed;
	}

	public void setSubscribed(boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", isSubscribed=" + isSubscribed + ", x=" + x + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}
