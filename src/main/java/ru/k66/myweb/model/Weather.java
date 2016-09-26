package ru.k66.myweb.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by ikydp on 19.09.2016.
 */
@Entity
@Table(name="WEATHER")
public class Weather {
    @Id
       private  String city;

    public void setCity(String city) {
        this.city = city;
    }
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column
    private Date date;

    @Column
    private int wDay1Day;
    @Column
    private int wDay1Evng;
    @Column
    private int wDay2Day;
    @Column
    private int wDay2Evng;
    @Column
    private int wDay3Day;
    @Column
    private int wDay3Evng;

    public Weather() {
    }

    public String getCity() {
        return city;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getwDay1Day() {
        return wDay1Day;
    }

    public void setwDay1Day(int wDay1Day) {
        this.wDay1Day = wDay1Day;
    }

    public int getwDay1Evng() {
        return wDay1Evng;
    }

    public void setwDay1Evng(int wDay1Evng) {
        this.wDay1Evng = wDay1Evng;
    }

    public int getwDay2Day() {
        return wDay2Day;
    }

    public void setwDay2Day(int wDay2Day) {
        this.wDay2Day = wDay2Day;
    }

    public int getwDay2Evng() {
        return wDay2Evng;
    }

    public void setwDay2Evng(int wDay2Evng) {
        this.wDay2Evng = wDay2Evng;
    }

    public int getwDay3Day() {
        return wDay3Day;
    }

    public void setwDay3Day(int wDay3Day) {
        this.wDay3Day = wDay3Day;
    }

    public int getwDay3Evng() {
        return wDay3Evng;
    }

    public void setwDay3Evng(int wDay3Evng) {
        this.wDay3Evng = wDay3Evng;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weather)) return false;

        Weather otherEmployee = (Weather) o;


        if (getDate() != null ?
                !getDate().equals(otherEmployee.getDate()) : otherEmployee.getDate() != null)
            return false;

        if (getCity() != null ?
                !getCity().equals(otherEmployee.getCity()) : otherEmployee.getCity() != null)
            return false;



        return true;
    }
    @Override
    public int hashCode() {
        int result = getCity() != null ? getCity().hashCode() : 0;
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getDate() != null?getDate().hashCode() : 0);
        return result;
    }




}
