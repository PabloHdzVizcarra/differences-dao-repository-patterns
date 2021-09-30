package jvm.pablohdz.daorepositorypatternexample.dto;

public class UserRequest {
    private String username;
    private String name;
    private String email;

    public UserRequest() {
    }

    public UserRequest(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void validateFields() {
        if (this.email.equals("") || this.name.equals("") || this.username.equals(""))
            throw new RuntimeException("try save empty values, please check data");
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
