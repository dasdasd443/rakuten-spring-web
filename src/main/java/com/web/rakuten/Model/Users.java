package com.web.rakuten.Model;

import javax.persistence.*;

@Entity
@Table
public class Users {
    
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String email;
    private String password;
    public Users() {
    }
    public Users(Long id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
    public Users(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
    @Override
    public String toString() {
        return "Users [email=" + email + ", fullName=" + fullName + ", id=" + id + ", password=" + password + "]";
    }
}
