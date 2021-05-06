package models;

public class AppUser {
    private int id;
    private String username;
    private String password;

    public AppUser(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        if (password == null) {
            return;
        }

        password = password.trim();

        if (!password.equalsIgnoreCase("")) {
            this.password = password;
        }
    }

    public void setUsername(String username) {
        if (username == null) {
            return;
        }

        username = username.trim();

        if (!username.equalsIgnoreCase("")) {
            this.username = username;
        }
    }
}
