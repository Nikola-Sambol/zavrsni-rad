package com.mev.zavrsnirad.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="recepti")
public class Recept {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="naziv")
    private String nazivRecepta;

    @Column(name="datum_kreiranja", updatable = false, insertable = false)
    private LocalDate kreirano;

    @Column(name="putanja_slika")
    private String putanjaSlike;

    @Column(name="putanja_video")
    private String putanjaVideo;

    @ManyToOne
    @JoinColumn(name="korisnik_id")
    private Korisnik korisnik;

    @OneToOne
    @JoinColumn(name="sastav_id", unique = true)
    private Sastav sastav;

    @OneToOne
    @JoinColumn(name="instrukcija_id", unique = true)
    private Instrukcije instrukcija;

    @ManyToOne
    @JoinColumn(name="kategorija_id", nullable = false)
    private Kategorija kategorija;

    public Recept() {

    }

    public Recept(String nazivRecepta, LocalDate kreirano, String putanjaSlike, String putanjaVideo,
                  Korisnik korisnik, Sastav sastav, Instrukcije instrukcija, Kategorija kategorija) {
        this.nazivRecepta = nazivRecepta;
        this.kreirano = kreirano;
        this.putanjaSlike = putanjaSlike;
        this.putanjaVideo = putanjaVideo;
        this.korisnik = korisnik;
        this.sastav = sastav;
        this.instrukcija = instrukcija;
        this.kategorija = kategorija;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivRecepta() {
        return nazivRecepta;
    }

    public void setNazivRecepta(String nazivRecepta) {
        this.nazivRecepta = nazivRecepta;
    }

    public LocalDate getKreirano() {
        return kreirano;
    }

    public void setKreirano(LocalDate kreirano) {
        this.kreirano = kreirano;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
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

    public String getPutanjaSlike() {
        return putanjaSlike;
    }

    public void setPutanjaSlike(String putanjaSlike) {
        this.putanjaSlike = putanjaSlike;
    }

    public String getPutanjaVideo() {
        return putanjaVideo;
    }

    public void setPutanjaVideo(String putanjaVideo) {
        this.putanjaVideo = putanjaVideo;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return "Recept{" +
                "id=" + id +
                ", nazivRecepta='" + nazivRecepta + '\'' +
                ", kreirano=" + kreirano +
                '}';
    }
}
