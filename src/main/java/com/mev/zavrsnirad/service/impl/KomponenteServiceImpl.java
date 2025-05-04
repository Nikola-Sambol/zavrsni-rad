package com.mev.zavrsnirad.service.impl;

import com.mev.zavrsnirad.entity.Komponente;
import com.mev.zavrsnirad.repository.KomponenteRepository;
import com.mev.zavrsnirad.service.KomponenteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomponenteServiceImpl implements KomponenteService {

    private KomponenteRepository komponenteRepository;

    public KomponenteServiceImpl(KomponenteRepository komponenteRepository) {
        this.komponenteRepository = komponenteRepository;
    }

    @Override
    public Komponente kreirajKomponentu(Komponente komponenta) {
        return komponenteRepository.save(komponenta);
    }

    @Override
    public Komponente azurirajKomponentu(Integer id, Komponente komponenta) {
        Komponente privremenaKomponenta = komponenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Komponenta sa id-jem " + id + " ne postoji."));

        privremenaKomponenta.setNazivKomponente(komponenta.getNazivKomponente());
        privremenaKomponenta.setPutanjaSlike(komponenta.getPutanjaSlike());

        return komponenteRepository.save(privremenaKomponenta);
    }

    @Override
    public void obrisiKomponentu(Integer id) {
        komponenteRepository.deleteById(id);
    }

    @Override
    public Komponente dohvatiKomponentu(Integer id) {
        return komponenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Komponenta sa id-jem " + id + " ne postoji."));
    }

    @Override
    public List<Komponente> dohvatiSveKomponente() {
        return komponenteRepository.findAll();
    }
}
