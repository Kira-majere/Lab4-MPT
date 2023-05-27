package org.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Picture {
    private int id;
    private String name;
    private boolean graduating;
    private Set<Rectangle> staff = new LinkedHashSet<>();

    @Basic
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "graduating")
    public boolean isGraduating() {
        return graduating;
    }

    public void setGraduating(boolean graduating) {
        this.graduating = graduating;
    }

    @OneToMany(mappedBy = "picture")
    public Set<Rectangle> getStaff() {
        return staff;
    }

    public void setStaff(Set<Rectangle> staff) {
        this.staff = staff;
    }
}
