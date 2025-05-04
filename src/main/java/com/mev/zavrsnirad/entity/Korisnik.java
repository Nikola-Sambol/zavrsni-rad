package com.mev.zavrsnirad.entity;

import com.mev.zavrsnirad.enums.Uloga;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="korisnici")
public class Korisnik {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="ime", columnDefinition="TEXT")
    private String ime;

    @Column(name="prezime", columnDefinition="TEXT")
    private String prezime;

    @Column(name="email", columnDefinition="TEXT")
    private String email;

    @Column(name="lozinka", columnDefinition="TEXT")
    private String lozinka;

    @Column(name="uloga")
    @Enumerated(EnumType.STRING)
    private Uloga uloga;

    @OneToMany(mappedBy="korisnik", cascade=CascadeType.ALL)
    private List<Recept> recepti;

    public Korisnik() {

    }

    public Korisnik(String ime, String prezime, String email, String lozinka, Uloga uloga) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.uloga = uloga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
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
        recept.setKorisnik(this);
    }

    public void removeRecept(Recept recept) {
        if (recepti != null) {
            recepti.remove(recept);
            recept.setKorisnik(null);
        }
    }


    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", uloga=" + uloga +
                '}';
    }
}
