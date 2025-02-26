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

    @OneToOne(mappedBy="sastav", cascade = CascadeType.ALL)
    private Recept recept;

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

    @Override
    public String toString() {
        return "Sastav{" +
                "id=" + id +
                ", opis='" + opis + '\'' +
                ", recept=" + recept +
                '}';
    }
}
