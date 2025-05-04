package com.mev.zavrsnirad.service;

import com.mev.zavrsnirad.entity.Kategorija;

import java.util.List;

public interface KategorijaService {

    Kategorija kreirajKategoriju(Kategorija kategorija);

    Kategorija azurirajKategoriju(Integer id, Kategorija kategorija);

    void obrisiKategoriju(Integer id);

    Kategorija dohvatiKategoriju(Integer id);

    List<Kategorija> dohvatiSveKategorije();
}
