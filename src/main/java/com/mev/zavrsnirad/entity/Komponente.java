package com.mev.zavrsnirad.entity;

import jakarta.persistence.*;

@Entity
@Table(name="komponente")
public class Komponente {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="naziv_komponente", columnDefinition="TEXT")
    private String nazivKomponente;

    @Column(name="putanja_slike", columnDefinition="TEXT")
    private String putanjaSlike;

    @ManyToOne
    @JoinColumn(name="recept_id")
    private Recept recept;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sastav_id", unique = true)
    private Sastav sastav;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instrukcije_id", unique = true)
    private Instrukcije instrukcija;

    public Komponente() {

    }

    public Komponente(String nazivKomponente, String putanjaSlike, Recept recept, Sastav sastav, Instrukcije instrukcija) {
        this.nazivKomponente = nazivKomponente;
        this.putanjaSlike = putanjaSlike;
        this.recept = recept;
        this.sastav = sastav;
        this.instrukcija = instrukcija;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivKomponente() {
        return nazivKomponente;
    }

    public void setNazivKomponente(String nazivKomponente) {
        this.nazivKomponente = nazivKomponente;
    }

    public String getPutanjaSlike() {
        return putanjaSlike;
    }

    public void setPutanjaSlike(String putanjaSlike) {
        this.putanjaSlike = putanjaSlike;
    }

    public Recept getRecept() {
        return recept;
    }

    public void setRecept(Recept recept) {
        this.recept = recept;
    }

    public Sastav getSastav() {
        return sastav;
    }

    public void setSastav(Sastav sastav) {
        this.sastav = sastav;
    }

    public Instrukcije getInstrukcija() {
        return instrukcija;
    }

    public void setInstrukcija(Instrukcije instrukcija) {
        this.instrukcija = instrukcija;
    }

    @Override
    public String toString() {
        return "Komponente{" +
                "id=" + id +
                ", nazivKomponente='" + nazivKomponente + '\'' +
                '}';
    }
}
