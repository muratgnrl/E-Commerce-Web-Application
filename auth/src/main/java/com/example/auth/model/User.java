package com.example.auth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Builder
@Log4j2
@Entity
@Table(name = "Kullanıcı")
public class User extends BaseEntity implements Serializable {

    @Column(name = "kullanıcı_soyisim")
    private String lastName;
    @Column(name = "kullanıcı_ismi")
    private String firstName;
    @Column(name = "password",unique = true,nullable = false)
    private String password;
    @Column(name = "e_mail",unique = true,nullable = false)
    private String mail;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public User() {
    }

    public User(String lastName, String firstName, String password, String mail) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.mail = mail;
    }
}
