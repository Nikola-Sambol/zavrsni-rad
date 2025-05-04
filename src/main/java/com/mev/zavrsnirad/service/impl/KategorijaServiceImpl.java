package com.mev.zavrsnirad.service.impl;

import com.mev.zavrsnirad.entity.Kategorija;
import com.mev.zavrsnirad.repository.KategorijaRepository;
import com.mev.zavrsnirad.service.KategorijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategorijaServiceImpl implements KategorijaService {

    private KategorijaRepository kategorijaRepository;

    public KategorijaServiceImpl(KategorijaRepository kategorijaRepository) {
        this.kategorijaRepository = kategorijaRepository;
    }

    @Override
    public Kategorija kreirajKategoriju(Kategorija kategorija) {
        return kategorijaRepository.save(kategorija);
    }

    @Override
    public Kategorija azurirajKategoriju(Integer id, Kategorija kategorija) {
        Kategorija privremenaKategorija = kategorijaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategorija sa id-jem " + id + " ne postoji."));

        privremenaKategorija.setNaziv(kategorija.getNaziv());

        return kategorijaRepository.save(privremenaKategorija);
    }

    @Override
    public void obrisiKategoriju(Integer id) {
        kategorijaRepository.deleteById(id);
    }

    @Override
    public Kategorija dohvatiKategoriju(Integer id) {
        return kategorijaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategorija sa id-jem " + id + " ne postoji."));
    }

    @Override
    public List<Kategorija> dohvatiSveKategorije() {
        return kategorijaRepository.findAll();
    }
}
