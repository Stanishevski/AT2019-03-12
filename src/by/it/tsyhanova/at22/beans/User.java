package by.it.tsyhanova.at22.beans;

import java.util.Date;

public class User {
    private long id;
    private String username;
    private String password;
    private String email;
    private Date date;

    //we need empty constructor Code>Generate>Constructor>Select None
    public User() {
    }
    //we need constructors for all fields

    public User(long id, String username, String password, String email, Date date) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.date = date;
    }

    //we need get & set
    //Code>Generate>Getter and Setter

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
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //we need to String
    //Code>Generate>toString()
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}
