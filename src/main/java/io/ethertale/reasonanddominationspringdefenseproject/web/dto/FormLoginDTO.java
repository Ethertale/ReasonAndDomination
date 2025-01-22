package io.ethertale.reasonanddominationspringdefenseproject.web.dto;

public class FormLoginDTO {
    private String email;
    private String password;

    public FormLoginDTO() {
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
}
