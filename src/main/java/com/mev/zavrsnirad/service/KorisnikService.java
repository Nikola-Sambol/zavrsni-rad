package com.mev.zavrsnirad.service;

import com.mev.zavrsnirad.entity.Korisnik;

import java.util.List;

public interface KorisnikService {

    Korisnik kreirajKorisnika(Korisnik korisnik);

    Korisnik azurirajKorisnika(Integer id, Korisnik korisnik);

    void obrisiKorisnika(Integer id);

    Korisnik dohvatiKorisnika(Integer id);

    List<Korisnik> dohvatiSveKorisnike();
}
