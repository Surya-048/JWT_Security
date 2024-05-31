package rest.Rest_Beginning.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class RegisterLoginUserDto {
    private String email;

    private String password;

    private String role;

    public RegisterLoginUserDto(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.role = fullName;
    }
    public RegisterLoginUserDto(){}

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + role + '\'' +
                '}';
    }
}
