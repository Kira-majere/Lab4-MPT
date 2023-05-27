package org.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Rectangle {
    private int id;
    private int ugol;
    private String colorline;
    private String colorback;
    private int lengt;
    private int wight;
    private Picture picture;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ugol")
    public int getUgol() {
        return ugol;
    }

    public void setUgol(int ugol) {
        this.ugol = ugol;
    }

    @Basic
    @Column(name = "colorline")
    public String getColorline() {
        return colorline;
    }

    public void setColorline(String colorline) {
        this.colorline = colorline;
    }

    @Basic
    @Column(name = "colorback")
    public String getColorback() {
        return colorback;
    }

    public void setColorback(String colorback) {
        this.colorback = colorback;
    }

    @Basic
    @Column(name = "lengt")
    public int getLengt() {
        return lengt;
    }

    public void setLengt(int lengt) {
        this.lengt = lengt;
    }

    @Basic
    @Column(name = "wight")
    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_id")
    public Picture getPicture() {
        return picture;
    }

   public void setPicture(Picture picture) {
       this.picture = picture;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return id == rectangle.id && ugol== rectangle.ugol && Objects.equals(colorline, rectangle.colorline) && Objects.equals(colorback, rectangle.colorback) && lengt== rectangle.lengt && wight== rectangle.wight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ugol, colorline, colorback, lengt, wight);
    }
}
