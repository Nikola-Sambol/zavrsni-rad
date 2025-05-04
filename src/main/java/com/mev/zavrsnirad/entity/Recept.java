package com.mev.zavrsnirad.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="recepti")
public class Recept {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="naziv", columnDefinition="TEXT")
    private String nazivRecepta;

    @Column(name="datum_kreiranja", updatable = false, insertable = false)
    private LocalDate kreirano;

    @Column(name="putanja_slika", columnDefinition="TEXT")
    private String putanjaSlike;

    @Column(name="putanja_video", columnDefinition="TEXT")
    private String putanjaVideo;

    @Column(name="vrijeme_pripreme", columnDefinition="TEXT")
    private String vrijemePripreme;

    @ManyToOne
    @JoinColumn(name="korisnik_id")
    private Korisnik korisnik;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sastav_id", unique = true)
    private Sastav sastav;

    @OneToMany(mappedBy = "recept")
    private List<Komponente> komponente;

    @ManyToOne
    @JoinColumn(name="kategorija_id", nullable = false)
    private Kategorija kategorija;


    public Recept() {

    }

    public Recept(String nazivRecepta, String putanjaSlike, String putanjaVideo,
                  String vrijemePripreme, Korisnik korisnik, Sastav sastav, Kategorija kategorija) {
        this.nazivRecepta = nazivRecepta;
        this.putanjaSlike = putanjaSlike;
        this.putanjaVideo = putanjaVideo;
        this.vrijemePripreme = vrijemePripreme;
        this.korisnik = korisnik;
        this.sastav = sastav;
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

    public String getVrijemePripreme() {
        return vrijemePripreme;
    }

    public void setVrijemePripreme(String vrijemePripreme) {
        this.vrijemePripreme = vrijemePripreme;
    }

    public List<Komponente> getKomponente() {
        return komponente;
    }

    public void setKomponente(List<Komponente> komponente) {
        this.komponente = komponente;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public void addKomponenta(Komponente komponenta) {
        if (komponente == null) {
            komponente = new ArrayList<>();
        }
        komponente.add(komponenta);
        komponenta.setRecept(this);
    }

    public void removeKomponenta(Komponente komponenta) {
        if (komponente != null) {
            komponente.remove(komponenta);
            komponenta.setRecept(null);
        }
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
