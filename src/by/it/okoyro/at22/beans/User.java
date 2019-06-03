package by.it.okoyro.at22.beans;

import java.util.Date;

public class User {
	private long id;
	private String username;
	private String password;
	private String email;
	private Date create_time;

	public User() {
	}

	public User(long id, String username, String password, String email, Date create_time) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.create_time = create_time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public Date getDate() {
		return create_time;
	}

	public void setDate(Date date) {
		this.create_time = date;
	}


	@Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

     User user = (User) o;

     if (username != null ? !username.equals(user.getUsername()) : user.getUsername() != null) return false;
     if (password != null ? !password.equals(user.getPassword()) : user.getPassword() != null) return false;
     return email != null ? email.equals(user.getEmail()) : user.getEmail() == null;
 }

	@Override
	public String toString() {
		return "User{" +
			   "id=" + id +
			   ", username='" + username + '\'' +
			   ", password='" + password + '\'' +
			   ", email='" + email + '\'' +
			   ", create_time=" + create_time +
			   '}';
	}
}
