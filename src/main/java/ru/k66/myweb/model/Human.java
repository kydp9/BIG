package ru.k66.myweb.model;


import javax.persistence.*;





@Entity
@Table(name="humanslist")

public class Human {
@Id
//@Column(name = "id" , unique = true, nullable=false)
@GeneratedValue(strategy = GenerationType.AUTO) // для авточисла? =)
    private int id;
    @Column(name = "first")
    private String name;
    @Column(name = "second")
    private String secondName;
    @Column(name = "last")
    private String surname;
    @Column(name = "car")
    private String car;
    @Column(name = "city")
    private String city;

    public Human() {
    }

    public Human(int id, String name, String secondName, String surname, String car, String city) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.car = car;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public String getCar() {
        return car;
    }

    public String getCity() {
        return city;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setCity(String city) {
        this.city = city;
    }


}