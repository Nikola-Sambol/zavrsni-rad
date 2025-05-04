package com.mev.zavrsnirad.service.impl;

import com.mev.zavrsnirad.entity.Sastav;
import com.mev.zavrsnirad.repository.SastavRepository;
import com.mev.zavrsnirad.service.SastavService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SastavServiceImpl implements SastavService {

    private SastavRepository sastavRepository;

    public SastavServiceImpl(SastavRepository sastavRepository) {
        this.sastavRepository = sastavRepository;
    }

    @Override
    public Sastav kreirajSastav(Sastav sastav) {
        return sastavRepository.save(sastav);
    }

    @Override
    public Sastav azurirajSastav(Integer id, Sastav sastav) {
        Sastav privremeniSastav = sastavRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sastav sa id-jem " + id + " ne postoji."));

        privremeniSastav.setOpis(sastav.getOpis());

        return sastavRepository.save(privremeniSastav);
    }

    @Override
    public void obrisiSastav(Integer id) {
        sastavRepository.deleteById(id);
    }

    @Override
    public Sastav dohvatiSastav(Integer id) {
        return sastavRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sastav sa id-jem " + id + " ne postoji."));
    }

    @Override
    public List<Sastav> dohvatiSveSastave() {
        return sastavRepository.findAll();
    }
}
