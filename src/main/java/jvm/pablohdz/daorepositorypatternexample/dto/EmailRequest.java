package jvm.pablohdz.daorepositorypatternexample.dto;

public class EmailRequest {
    private final String email;

    public EmailRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
