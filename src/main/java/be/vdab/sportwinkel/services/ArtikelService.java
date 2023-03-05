package be.vdab.sportwinkel.services;

import be.vdab.sportwinkel.domain.Artikel;
import be.vdab.sportwinkel.events.ArtikelGemaakt;
import be.vdab.sportwinkel.repositories.ArtikelGemaaktRepository;
import be.vdab.sportwinkel.repositories.ArtikelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ArtikelService {
    private final ArtikelRepository artikelRepository;
    private final ArtikelGemaaktRepository artikelGemaaktRepository;

    public ArtikelService(ArtikelRepository artikelRepository,
                          ArtikelGemaaktRepository artikelGemaaktRepository) {
        this.artikelRepository = artikelRepository;
        this.artikelGemaaktRepository = artikelGemaaktRepository;
    }

    public void create(Artikel artikel) {
        artikelRepository.save(artikel);
        artikelGemaaktRepository.save(new ArtikelGemaakt(artikel));
        //template.convertAndSend("sportartikels", null, new ArtikelGemaakt(artikel));
    }
}
