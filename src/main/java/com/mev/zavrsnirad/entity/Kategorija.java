package com.mev.zavrsnirad.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="kategorija")
public class Kategorija {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="naziv", columnDefinition="TEXT")
    private String naziv;

    @OneToMany(mappedBy="kategorija", cascade=CascadeType.ALL)
    private List<Recept> recepti;


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

    public List<Recept> getRecepti() {
        return recepti;
    }

    public void setRecepti(List<Recept> recepti) {
        this.recepti = recepti;
    }

    public void addRecept(Recept recept) {
        if (recepti == null) {
            recepti = new ArrayList<>();
        }
        recepti.add(recept);
        recept.setKategorija(this);
    }

    public void removeRecept(Recept recept) {
        if (recepti != null) {
            recepti.remove(recept);
            recept.setKategorija(null);
        }
    }


    @Override
    public String toString() {
        return "Kategorija{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
