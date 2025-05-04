package com.mev.zavrsnirad.service;

import com.mev.zavrsnirad.entity.Instrukcije;

import java.util.List;

public interface InstrukcijeService {

    Instrukcije kreirajInstrukciju(Instrukcije instrukcija);

    Instrukcije azurirajInstrukciju(Integer id, Instrukcije instrukcija);

    void obrisiInstrukciju(Integer id);

    List<Instrukcije> dohvatiSveInstrukcije();

    Instrukcije dohvatiInstrukciju(Integer id);
}
