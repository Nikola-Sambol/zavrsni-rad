package com.mev.zavrsnirad.entity;

import jakarta.persistence.*;

@Entity
@Table(name="sastav")
public class Sastav {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="opis", columnDefinition="TEXT")
    private String opis;

    @OneToOne(mappedBy="sastav")
    private Recept recept;

    @OneToOne(mappedBy = "sastav")
    private Komponente komponente;

    public Sastav() {

    }

    public Sastav(String opis) {
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

    public Recept getRecept() {
        return recept;
    }

    public void setRecept(Recept recept) {
        this.recept = recept;
    }

    public Komponente getKomponente() {
        return komponente;
    }

    public void setKomponente(Komponente komponente) {
        this.komponente = komponente;
    }

    @Override
    public String toString() {
        return "Sastav{" +
                "id=" + id +
                ", opis='" + opis + '\'' +
                ", recept=" + recept +
                '}';
    }
}
