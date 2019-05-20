package API.models.dto;

public class AccountCredentialsDTO {

    private String login;
    private String password;

    public AccountCredentialsDTO() {

    }

    public AccountCredentialsDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
