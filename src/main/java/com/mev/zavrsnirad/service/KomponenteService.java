package com.mev.zavrsnirad.service;

import com.mev.zavrsnirad.entity.Komponente;

import java.util.List;

public interface KomponenteService {

    Komponente kreirajKomponentu(Komponente komponenta);

    Komponente azurirajKomponentu(Integer id, Komponente komponenta);

    void obrisiKomponentu(Integer id);

    Komponente dohvatiKomponentu(Integer id);

    List<Komponente> dohvatiSveKomponente();
}
