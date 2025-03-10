import java.util.UUID;

public class User {

    private int id;
    private String email;
    private String password;
    private String userName;
    private int reputation;


    public User(int id, String email, String password, String userName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.reputation = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}
