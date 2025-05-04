package com.mev.zavrsnirad.service.impl;

import com.mev.zavrsnirad.entity.Recept;
import com.mev.zavrsnirad.repository.ReceptRepository;
import com.mev.zavrsnirad.service.ReceptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptServiceImpl implements ReceptService {

    private ReceptRepository receptRepository;

    public ReceptServiceImpl(ReceptRepository receptRepository) {
        this.receptRepository = receptRepository;
    }

    @Override
    public Recept kreirajRecept(Recept recept) {
        return receptRepository.save(recept);
    }

    @Override
    public Recept azurirajRecept(Integer id, Recept recept) {
        Recept privremeniRecept = receptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recept sa id-jem " + id + " ne postoji."));

        privremeniRecept.setNazivRecepta(recept.getNazivRecepta());
        privremeniRecept.setPutanjaSlike(recept.getPutanjaSlike());
        privremeniRecept.setPutanjaVideo(recept.getPutanjaVideo());
        privremeniRecept.setVrijemePripreme(recept.getVrijemePripreme());

        return receptRepository.save(privremeniRecept);
    }

    @Override
    public void obrisiRecept(Integer id) {
        receptRepository.deleteById(id);
    }

    @Override
    public Recept dohvatiRecept(Integer id) {
        return receptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recept sa id-jem " + id + " ne postoji."));
    }

    @Override
    public List<Recept> dohvatiSveRecepte() {
        return receptRepository.findAll();
    }
}
