package pojo;

public class User {
    private String userName;
    private String email;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public User(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
