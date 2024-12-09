package isi.pe.security_service.model;

public class SignUpRequest {

    private String username;
    private String password;
    private String role;
    private String name;

    public SignUpRequest(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public SignUpRequest() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SignUpRequest username(String username) {
        this.username = username;
        return this;
    }

    public SignUpRequest password(String password) {
        this.password = password;
        return this;
    }

    public SignUpRequest role(String role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
}
