package ba.unsa.etf.ppis.telekom.models;

import javax.persistence.*;

@Entity
public class User {



    public enum Gender{MALE, FEMALE, OTHER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User() { }

    public User(String username, String password, String email, String phoneNumber, Gender gender, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.role = role;
    }

    public User(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }

}
