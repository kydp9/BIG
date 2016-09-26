package ru.k66.myweb.model;

import javax.persistence.*;






@Entity
@Table(name="userdata")
public class User {


    @Id
//@Column(name = "id" , unique = true, nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO) // для авточисла? =)
    private int userId;
    @Column(name = "name")
    private String name;
    @Column(name = "second")
    private String second;
    @Column(name = "surname")
    private String surname;

    @Column(name = "sendto")
    private String sendto;

    @Column(name = "email")
    private String email;
    @Column(name = "subject")
    private String subject;

    @Column(name = "text")
    private String text;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSendto() {
        return sendto;
    }

    public void setSendto(String sendto) {
        this.sendto = sendto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
