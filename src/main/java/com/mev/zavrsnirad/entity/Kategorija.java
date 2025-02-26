package com.mev.zavrsnirad.entity;

import jakarta.persistence.*;

@Entity
@Table(name="kategorija")
public class Kategorija {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="naziv")
    private String naziv;

    public Kategorija() {

    }

    public Kategorija(String naziv) {
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Kategorija{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
