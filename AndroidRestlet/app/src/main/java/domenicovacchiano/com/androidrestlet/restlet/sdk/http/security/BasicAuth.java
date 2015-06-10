package domenicovacchiano.com.androidrestlet.restlet.sdk.http.security;

/**
 * Created by domenicovacchiano on 10/06/15.
 */
public class BasicAuth {

    private String username;
    private String password;
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

}
