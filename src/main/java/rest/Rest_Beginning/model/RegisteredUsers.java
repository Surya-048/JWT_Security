package rest.Rest_Beginning.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "register_employee")
public class RegisteredUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    private String role;

    public RegisteredUsers(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public RegisteredUsers(){}

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RegisteredEmp{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + role + '\'' +
                '}';
    }
}
