package com.mev.zavrsnirad.entity;

import jakarta.persistence.*;

@Entity
@Table(name="instrukcije")
public class Instrukcije {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="opis", columnDefinition="TEXT")
    private String opis;

    @OneToOne(mappedBy="instrukcija")
    private Komponente komponente;

    public Instrukcije() {

    }

    public Instrukcije(String opis) {
        this.opis = opis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Komponente getKomponente() {
        return komponente;
    }

    public void setKomponente(Komponente komponente) {
        this.komponente = komponente;
    }

    @Override
    public String toString() {
        return "Instrukcije{" +
                "id=" + id +
                ", opis='" + opis + '\'' +
                '}';
    }
}
