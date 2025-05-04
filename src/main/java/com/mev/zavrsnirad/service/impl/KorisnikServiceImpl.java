package com.mev.zavrsnirad.service.impl;

import com.mev.zavrsnirad.entity.Korisnik;
import com.mev.zavrsnirad.repository.KorisnikRepository;
import com.mev.zavrsnirad.service.KorisnikService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik kreirajKorisnika(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    @Override
    public Korisnik azurirajKorisnika(Integer id, Korisnik korisnik) {
        Korisnik privremeniKorisnik = korisnikRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Korisnik sa id-jem " + id + " ne postoji."));

        privremeniKorisnik.setIme(korisnik.getIme());
        privremeniKorisnik.setPrezime(korisnik.getPrezime());
        privremeniKorisnik.setEmail(korisnik.getEmail());
        privremeniKorisnik.setLozinka(korisnik.getLozinka());
        privremeniKorisnik.setUloga(korisnik.getUloga());

        return korisnikRepository.save(privremeniKorisnik);
    }

    @Override
    public void obrisiKorisnika(Integer id) {
        korisnikRepository.deleteById(id);
    }

    @Override
    public Korisnik dohvatiKorisnika(Integer id) {
        return korisnikRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Korisnik sa id-jem " + id + " ne postoji."));
    }

    @Override
    public List<Korisnik> dohvatiSveKorisnike() {
        return korisnikRepository.findAll();
    }
}
