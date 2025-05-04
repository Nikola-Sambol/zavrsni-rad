package com.mev.zavrsnirad.service;

import com.mev.zavrsnirad.entity.Recept;

import java.util.List;

public interface ReceptService {

    Recept kreirajRecept(Recept recept);

    Recept azurirajRecept(Integer id, Recept recept);

    void obrisiRecept(Integer id);

    Recept dohvatiRecept(Integer id);

    List<Recept> dohvatiSveRecepte();
}
