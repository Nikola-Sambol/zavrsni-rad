package com.mev.zavrsnirad.service.impl;

import com.mev.zavrsnirad.entity.Instrukcije;
import com.mev.zavrsnirad.repository.InstrukcijeRepository;
import com.mev.zavrsnirad.service.InstrukcijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrukcijeServiceImpl implements InstrukcijeService {

    private InstrukcijeRepository instrukcijeRepository;

    public InstrukcijeServiceImpl(InstrukcijeRepository instrukcijeRepository) {
        this.instrukcijeRepository = instrukcijeRepository;
    }

    @Override
    public Instrukcije kreirajInstrukciju(Instrukcije instrukcija) {
        return instrukcijeRepository.save(instrukcija);
    }

    @Override
    public Instrukcije azurirajInstrukciju(Integer id, Instrukcije instrukcija) {
        Instrukcije privremenaInstrukcija = instrukcijeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrukcija sa id-jem " + id + " ne postoji."));

        privremenaInstrukcija.setOpis(instrukcija.getOpis());

        return instrukcijeRepository.save(privremenaInstrukcija);
    }

    @Override
    public void obrisiInstrukciju(Integer id) {
        instrukcijeRepository.deleteById(id);
    }

    @Override
    public List<Instrukcije> dohvatiSveInstrukcije() {
        return instrukcijeRepository.findAll();
    }

    @Override
    public Instrukcije dohvatiInstrukciju(Integer id) {
        return instrukcijeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrukcija sa id-jem " + id + " ne postoji."));
    }
}
