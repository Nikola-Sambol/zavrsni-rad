package com.mev.zavrsnirad.service;

import com.mev.zavrsnirad.entity.Sastav;

import java.util.List;

public interface SastavService {

    Sastav kreirajSastav(Sastav sastav);

    Sastav azurirajSastav(Integer id, Sastav sastav);

    void obrisiSastav(Integer id);

    Sastav dohvatiSastav(Integer id);

    List<Sastav> dohvatiSveSastave();
}
